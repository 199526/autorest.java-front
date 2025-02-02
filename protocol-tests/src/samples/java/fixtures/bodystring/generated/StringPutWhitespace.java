// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.bodystring.generated;

import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import fixtures.bodystring.StringOperationClient;
import fixtures.bodystring.StringOperationClientBuilder;

public class StringPutWhitespace {
    public static void main(String[] args) {
        StringOperationClient stringOperationClient =
                new StringOperationClientBuilder().host("http://localhost:3000").buildClient();
        // BEGIN:fixtures.bodystring.generated.stringputwhitespace.stringputwhitespace
        RequestOptions requestOptions =
                new RequestOptions()
                        .setBody(
                                BinaryData.fromString(
                                        "\"<tab><space><space>Now is the time for all good men to come to the aid of their country<tab><space><space>\""));
        Response<Void> response = stringOperationClient.putWhitespaceWithResponse(requestOptions);
        // END:fixtures.bodystring.generated.stringputwhitespace.stringputwhitespace
    }
}
