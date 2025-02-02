// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.mapper;

import com.azure.autorest.extension.base.model.codemodel.Operation;
import com.azure.autorest.model.clientmodel.IType;

/**
 * @author xiaofeicao
 * @createdAt 2021-12-29 15:14
 */
public class ClientMethodMapperAccessor extends ClientMethodMapper{

    public static String getDescription(Operation operation, IType returnType, IType baseType) {
        return returnTypeDescription(operation, returnType, baseType);
    }

}
