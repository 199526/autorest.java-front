import {
  getServiceNamespace,
  getServiceNamespaceString,
  getServiceTitle,
  Program,
  Type,
  ModelType,
  ArrayType,
  StringLiteralType,
  NumericLiteralType,
  ModelTypeProperty,
  getSummary,
  getDoc,
  getMaxLength,
  getPattern,
  getMinLength,
  getFormat,
  getMaxValue,
  getMinValue,
  getFriendlyName,
  getVisibility,
  isIntrinsic,
} from "@cadl-lang/compiler";
import {
  getAllRoutes,
  getStatusCodeDescription,
  HttpOperationParameter,
  HttpOperationResponse,
  OperationDetails,
  StatusCode,
} from "@cadl-lang/rest/http";
import {
  CodeModel, 
  Operation, 
  Parameter, 
  Schema,
  StringSchema,
  HttpParameter,
  ImplementationLocation, 
  ParameterLocation,
  AnySchema,
  NumberSchema,
  SchemaType,
  ArraySchema,
  ObjectSchema,
  Property,
  Response,
  Request,
  SchemaResponse,
  BinarySchema,
} from "@autorest/codemodel";
import { fail } from "assert";

export class CodeModelBuilder {
  private program: Program;
  private namespace: string;
  private codeModel: CodeModel;

  private schemaCache = new ProcessingCache((type: Type, name: string) =>
    this.processSchemaImpl(type, name),
  );

  public constructor(program1: Program) {
    this.program = program1;

    const serviceNamespace = getServiceNamespace(this.program);
    if (serviceNamespace === undefined) {
      throw Error("Can not emit yaml for a namespace that doesn't exist.");
    }

    // let versions = getVersions(this.program, serviceNamespace);
    // if (versions.length === 0 && getServiceVersion(this.program)) {
    //   versions = [getServiceVersion(this.program)];
    // }
    this.namespace = getServiceNamespaceString(this.program)?.toLowerCase() || "client";

    const title = getServiceTitle(this.program);
    const description = this.getDoc(serviceNamespace);
    this.codeModel = new CodeModel(title, false, {
      info: {
        description: description
      },
      language: {
        default: {
          name: title,
          description: description,
          summary: this.getSummary(serviceNamespace)
        }
      }
    });
  }

  public build(): CodeModel {
    // TODO: parameterized host
    this.processHost();

    getAllRoutes(this.program)[0].map(it => this.processRoute(it));

    return this.codeModel;
  }

  private processHost() {
    this.codeModel.addGlobalParameter(this.hostParameter);
  }

  private processRoute(op: OperationDetails) {
    const operationGroup = this.codeModel.getOperationGroup(op.groupName);
    const opId = `${op.groupName}_${op.operation.name}`

    const operation = new Operation(op.operation.name, this.getDoc(op.operation), {
      operationId: opId,
      language: {
        default: {
          summary: this.getSummary(op.operation)
        }
      }
    });

    operation.addRequest(new Request({
      protocol: {
        http: {
          path: op.path,
          method: op.verb,
          uri: "{$host}"
        }
      }
    }));

    op.parameters.parameters.map(it => this.processParameter(operation, it));
    if (op.parameters.body) {
      this.processBody(operation, op.parameters.body);
    }
    op.responses.map(it => this.processResponse(operation, it));

    operationGroup.addOperation(operation);
  }

  private processParameter(op: Operation, param: HttpOperationParameter) {
    const schema = this.processSchema(param.param.type, param.param.name);
    const parameter = new Parameter(param.name, this.getDoc(param.param), schema, {
      implementation: ImplementationLocation.Method,
      required: !param.param.optional,
      protocol: {
        http: {
          in: param.type
        }
      },
      clientDefaultValue: this.getDefaultValue(param.param.default),
      language: {
        default: {
          serializedName: param.name
        }
      }
    });
    op.addParameter(parameter);
  }

  private processBody(op: Operation, body: ModelTypeProperty) {
    const schema = this.processSchema(body.type, body.name);
    const parameter = new Parameter(body.name, this.getDoc(body), schema, {
      implementation: ImplementationLocation.Method,
      required: !body.optional,
      protocol: {
        http: {
          in: "body"
        }
      },
      clientDefaultValue: this.getDefaultValue(body.default),
    });
    op.addParameter(parameter);
  }

  private processResponse(op: Operation, resp: HttpOperationResponse) {
    // TODO: what to do if more than 1?
    let response;
    if (resp.responses && resp.responses.length > 0 && resp.responses[0].body) {
      const responseBody = resp.responses[0].body;
      if (responseBody.type.kind === "Model" && responseBody.type.name === "bytes") {
        response = new BinarySchema(this.getResponseDescription(resp), {
          protocol: {
            http: {
              statusCodes: [this.getStatusCode(resp.statusCode)],
              mediaTypes: responseBody.contentTypes,
              knownMediaType: "binary"
            }
          }
        });
      } else {
        const schema = this.processSchema(responseBody.type, "response");
        response = new SchemaResponse(schema, {
          protocol: {
            http: {
              statusCodes: [this.getStatusCode(resp.statusCode)],
              mediaTypes: responseBody.contentTypes
            }
          },
          language: {
            default: {
              description: this.getResponseDescription(resp)
            }
          }
        });
      }
    } else {
      response = new Response({
        protocol: {
          http: {
            statusCodes: [this.getStatusCode(resp.statusCode)]
          }
        },
        language: {
          default: {
            description: this.getResponseDescription(resp)
          }
        }
      });
    }
    if (resp.statusCode === "*") {
      // TODO: x-ms-error-response
      op.addException(response);
    } else {
      op.addResponse(response);
    }
  }

  private getStatusCode(statusCode: StatusCode): string {
    return statusCode === "*" ? "default" : statusCode;
  }

  private getResponseDescription(resp: HttpOperationResponse): string {
    return resp.description || (resp.statusCode === "*" ? "An unexpected error response" : getStatusCodeDescription(resp.statusCode)) || "";
  }

  private processSchema(type: Type, name: string): Schema {
    return this.schemaCache.process(type, name) || fail("Unable to process schema.");
  }

  private processSchemaImpl(type: Type, name: string): Schema {
    switch (type.kind) {
      case "String":
        // TODO: getFormat
        // byte, binary, date, date-time, password
        return this.processStringSchema(type, name);
        
      case "Number":
        const isInteger = getFormat(this.program, type)?.startsWith("int");
        return isInteger ? this.processIntegerSchema(type, name) : this.processNumberSchema(type, name);

      case "Array":
        return this.processArraySchema(type, name);

      case "Model":
        if (isIntrinsic(this.program, type)) {
          // TODO: bytes, plainDate, zonedDateTime, plainTime, duration
          if (type.name === "string") {
            return this.processStringSchema(type, name);
          } else if (type.name.startsWith("int") || type.name.startsWith("uint") || type.name === "safeint") {
            return this.processIntegerSchema(type, name);
          } else if (type.name.startsWith("float")) {
            return this.processNumberSchema(type, name);
          } else {
            throw new Error(`Unrecognized intrinsic type: '${type.name}'.`);
          }
        } else {
          return this.processObjectSchema(type, this.getName(type, type.name));
        }
    }
    throw new Error(`Unrecognized type: '${type.kind}'.`);
  }

  private processStringSchema(type: StringLiteralType | ModelType, name: string): StringSchema {
    return this.codeModel.schemas.add(
      new StringSchema(name, this.getDoc(type), {
        summary: this.getSummary(type),
        maxLength: getMaxLength(this.program, type),
        minLength: getMinLength(this.program, type),
        pattern: getPattern(this.program, type)
      })
    );
  }

  private processIntegerSchema(type: NumericLiteralType | ModelType, name: string): NumberSchema {
    return this.codeModel.schemas.add(
      new NumberSchema(name, this.getDoc(type), SchemaType.Integer, 64, {
        summary: this.getSummary(type),
        maximum: getMaxValue(this.program, type),
        minimum: getMinValue(this.program, type)
      })
    );
  }

  private processNumberSchema(type: NumericLiteralType | ModelType, name: string): NumberSchema {
    return this.codeModel.schemas.add(
      new NumberSchema(name, this.getDoc(type), SchemaType.Number, 64, {
        summary: this.getSummary(type),
        maximum: getMaxValue(this.program, type),
        minimum: getMinValue(this.program, type)
      })
    );
  }

  private processArraySchema(type: ArrayType, name: string): ArraySchema {
    const elementSchema = this.processSchema(type.elementType, name);
    return this.codeModel.schemas.add(
      new ArraySchema(name, this.getDoc(type), elementSchema, {
        summary: this.getSummary(type),
        maxItems: getMaxLength(this.program, type),
        minItems: getMinLength(this.program, type),
      }));
  }

  private processObjectSchema(type: ModelType, name: string): ObjectSchema {
    const objectSchema = this.codeModel.schemas.add(
      new ObjectSchema(name, this.getDoc(type), {
        summary: this.getSummary(type)
      })
    );

    // cache this now before we accidentally recurse on this type.
    this.schemaCache.set(type, objectSchema);

    for (const [_, prop] of type.properties) {
      const schema = this.processSchema(prop.type, prop.name);
      objectSchema.addProperty(
        new Property(this.getName(prop, prop.name), this.getDoc(prop), schema, {
          required: !prop.optional,
          readOnly: !getVisibility(this.program, prop)?.includes("write"),
          serializedName: prop.name
        })
      );
    }

    return objectSchema;
  }

  private getDefaultValue(type: Type | undefined): any {
    if (type) {
      switch (type.kind) {
        case "String":
          return type.value;
        case "Number":
          return type.value;
        case "Boolean":
          return type.value;
        // case "Tuple":
        //   return type.values.map(getDefaultValue);
      }
    }
    return undefined;
  }

  private getDoc(target: Type): string {
    return getDoc(this.program, target) || "";
  }

  private getSummary(target: Type): string | undefined {
    return getSummary(this.program, target);
  }

  private getName(target: Type, name: string): string {
    return getFriendlyName(this.program, target) || name;
  }

  private _stringSchema?: StringSchema;
  get stringSchema() {
    return (
      this._stringSchema ||
      (this._stringSchema = this.codeModel.schemas.add(new StringSchema("string", "simple string")))
    );
  }

  private _binarySchema?: BinarySchema;
  get binarySchema() {
    return (
      this._binarySchema ||
      (this._binarySchema = this.codeModel.schemas.add(new BinarySchema("binary")))
    );
  }

  private _anySchema?: AnySchema;
  public get anySchema(): AnySchema {
    return this._anySchema ?? (this._anySchema = this.codeModel.schemas.add(new AnySchema("Anything")));
  }

  private _hostParameter?: Parameter;
  get hostParameter() {
    return (
      this._hostParameter ||
      (this._hostParameter = new Parameter("$host", "server parameter", this.stringSchema, {
        implementation: ImplementationLocation.Client,
        required: true,
        protocol: {
          http: new HttpParameter(ParameterLocation.Uri),
        },
        clientDefaultValue: "",
        language: {
          default: {
            serializedName: "$host"
          }
        },
        extensions: {
          "x-ms-skip-url-encoding": true
        }
      }))
    );
  }
}

class ProcessingCache<In, Out> {
  private results = new Map<In, Out>();
  constructor(private transform: (orig: In, ...args: Array<any>) => Out) {}
  has(original: In | undefined) {
    return !!original && !!this.results.get(original);
  }
  set(original: In, result: Out) {
    this.results.set(original, result);
    return result;
  }
  process(original: In | undefined, ...args: Array<any>): Out | undefined {
    if (original) {
      const result: Out = this.results.get(original) || this.transform(original, ...args);
      this.results.set(original, result);
      return result;
    }
    return undefined;
  }
}
