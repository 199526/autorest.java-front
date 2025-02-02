// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.mapper;

import com.azure.autorest.extension.base.model.codemodel.ObjectSchema;
import com.azure.autorest.extension.base.plugin.JavaSettings;
import com.azure.autorest.model.clientmodel.ClientException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExceptionMapper implements IMapper<ObjectSchema, ClientException> {
    private static final ExceptionMapper INSTANCE = new ExceptionMapper();
    Map<ObjectSchema, ClientException> parsed = new ConcurrentHashMap<>();

    protected ExceptionMapper() {
    }

    public static ExceptionMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public ClientException map(ObjectSchema compositeType) {
        if (compositeType == null) {
            return null;
        }

        return parsed.computeIfAbsent(compositeType, cType -> buildException(cType, JavaSettings.getInstance()));
    }

    protected ClientException buildException(ObjectSchema compositeType, JavaSettings settings) {
        String errorName = compositeType.getLanguage().getJava().getName();
        String methodOperationExceptionTypeName = errorName + "Exception";

        if (compositeType.getExtensions() != null && compositeType.getExtensions().getXmsClientName() != null) {
            methodOperationExceptionTypeName = compositeType.getExtensions().getXmsClientName();
        }

        boolean isCustomType = settings.isCustomType(methodOperationExceptionTypeName);
        String exceptionSubPackage = isCustomType
                ? settings.getCustomTypesSubpackage()
                : settings.getModelsSubpackage();
        String packageName = settings.getPackage(exceptionSubPackage);

        return createClientExceptionBuilder()
                .packageName(packageName)
                .name(methodOperationExceptionTypeName)
                .errorName(errorName)
                .build();
    }

    protected ClientException.Builder createClientExceptionBuilder() {
        return new ClientException.Builder();
    }
}
