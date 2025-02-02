// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.model.clientmodel;

import com.azure.autorest.extension.base.model.codemodel.Scheme;

import java.util.HashSet;
import java.util.Set;

public class SecurityInfo {

    private Set<Scheme.SecuritySchemeType> securityTypes = new HashSet<>();

    private Set<String> scopes = new HashSet<>();

    private String headerName;

    public Set<Scheme.SecuritySchemeType> getSecurityTypes() {
        return securityTypes;
    }

    public void setSecurityTypes(Set<Scheme.SecuritySchemeType> securityTypes) {
        this.securityTypes = securityTypes;
    }

    public Set<String> getScopes() {
        return scopes;
    }

    public void setScopes(Set<String> scopes) {
        this.scopes = scopes;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
}
