// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.model.clientmodel;

import com.azure.autorest.model.javamodel.JavaVisibility;

import java.util.Objects;
import java.util.Set;

/**
 * A property that exists within a service's client.
 */
public class ServiceClientProperty {

    public ServiceClientProperty() {
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(IType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefaultValueExpression(String defaultValueExpression) {
        this.defaultValueExpression = defaultValueExpression;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * The description of this property.
     */
    private String description;
    /**
     * The type of this property that is exposed via the client.
     */
    private IType type;
    /**
     * The name of this property.
     */
    private String name;

    /**
     * THe accessor method suffix of this property
     */
    private String accessorMethodSuffix;
    /**
     * Get whether or not this property's value can be changed by the client library.
     */
    private boolean readOnly;
    /**
     * Get the expression that evaluates to this property's default value.
     */
    private String defaultValueExpression;

    private JavaVisibility methodVisibility = JavaVisibility.Public;

    private boolean required;

    /**
     * Create a new ServiceClientProperty with the provided properties.
     * @param description The description of this property.
     * @param type The type of this property that is exposed via the client.
     * @param name The name of this property.
     * @param readOnly Whether or not this property's value can be changed by the client library.
     * @param defaultValueExpression The expression that evaluates to this property's default value.
     */
    public ServiceClientProperty(String description, IType type, String name, boolean readOnly, String defaultValueExpression) {
        this(description, type, name, readOnly, defaultValueExpression, name, JavaVisibility.Public, false);
    }

    public ServiceClientProperty(String description, IType type, String name, boolean readOnly, String defaultValueExpression, JavaVisibility methodVisibility) {
        this(description, type, name, readOnly, defaultValueExpression, name, methodVisibility, false);
    }

    private ServiceClientProperty(String description, IType type, String name, boolean readOnly, String defaultValueExpression,
                                  String accessorMethodSuffix, JavaVisibility methodVisibility, boolean required) {
        this.description = description;
        this.type = type;
        this.name = name;
        this.readOnly = readOnly;
        this.defaultValueExpression = defaultValueExpression;
        this.accessorMethodSuffix = accessorMethodSuffix;
        this.methodVisibility = methodVisibility;
        this.required = required;
    }

    public final String getDescription() {
        return description;
    }

    public final IType getType() {
        return type;
    }

    public final String getName() {
        return name;
    }

    public final String getAccessorMethodSuffix() {
        return accessorMethodSuffix;
    }

    public final boolean isReadOnly() {
        return readOnly;
    }

    public final String getDefaultValueExpression() {
        return defaultValueExpression;
    }

    public JavaVisibility getMethodVisibility() {
        return methodVisibility;
    }

    public boolean isRequired() {
        return required;
    }

    /**
     * Add this property's imports to the provided ISet of imports.
     * @param imports The set of imports to add to.
     * @param includeImplementationImports Whether or not to include imports that are only necessary for method implementations.
     */
    public final void addImportsTo(Set<String> imports, boolean includeImplementationImports) {
        getType().addImportsTo(imports, includeImplementationImports);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceClientProperty that = (ServiceClientProperty) o;
        return readOnly == that.readOnly &&
                Objects.equals(description, that.description) &&
                Objects.equals(type, that.type) &&
                Objects.equals(name, that.name) &&
                Objects.equals(defaultValueExpression, that.defaultValueExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, type, name, readOnly, defaultValueExpression);
    }

    public static final class Builder {
        private String description;
        private IType type;
        private String name;
        private String accessorMethodSuffix;
        private boolean readOnly = false;
        private String defaultValueExpression = null;
        private JavaVisibility methodVisibility = JavaVisibility.Public;
        private boolean required = false;

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder type(IType type) {
            this.type = type;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder accessorMethodSuffix(String accessorMethodSuffix) {
            this.accessorMethodSuffix = accessorMethodSuffix;
            return this;
        }

        public Builder readOnly(boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        public Builder defaultValueExpression(String defaultValueExpression) {
            this.defaultValueExpression = defaultValueExpression;
            return this;
        }

        public Builder methodVisibility(JavaVisibility methodVisibility) {
            this.methodVisibility = methodVisibility;
            return this;
        }

        public Builder required(boolean required) {
            this.required = required;
            return this;
        }

        public ServiceClientProperty build() {
            if (accessorMethodSuffix == null) {
                accessorMethodSuffix = name;
            }
            return new ServiceClientProperty(description, type, name, readOnly, defaultValueExpression,
                    accessorMethodSuffix, methodVisibility, required);
        }
    }
}
