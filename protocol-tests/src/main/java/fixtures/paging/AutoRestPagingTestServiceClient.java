// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.paging;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.util.BinaryData;

/** Initializes a new instance of the synchronous AutoRestPagingTestServiceClient type. */
@ServiceClient(builder = AutoRestPagingTestServiceClientBuilder.class)
public final class AutoRestPagingTestServiceClient {
    @Generated private final AutoRestPagingTestServiceAsyncClient client;

    /**
     * Initializes an instance of AutoRestPagingTestServiceClient class.
     *
     * @param client the async client.
     */
    @Generated
    AutoRestPagingTestServiceClient(AutoRestPagingTestServiceAsyncClient client) {
        this.client = client;
    }

    /**
     * A paging operation that must return result of the default 'value' node.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     value: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getNoItemNamePages(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getNoItemNamePages(requestOptions));
    }

    /**
     * A paging operation that must ignore any kind of nextLink, and stop after page 1.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getNullNextLinkNamePages(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getNullNextLinkNamePages(requestOptions));
    }

    /**
     * A paging operation that finishes on the first call without a nextlink.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getSinglePages(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getSinglePages(requestOptions));
    }

    /**
     * A paging operation whose first response's items list is empty, but still returns a next link. Second (and final)
     * call, will give you an items list of 1.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     value: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> firstResponseEmpty(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.firstResponseEmpty(requestOptions));
    }

    /**
     * A paging operation that includes a nextLink that has 10 pages.
     *
     * <p><strong>Header Parameters</strong>
     *
     * <table border="1">
     *     <caption>Header Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>client-request-id</td><td>String</td><td>No</td><td>The clientRequestId parameter</td></tr>
     *     <tr><td>maxresults</td><td>String</td><td>No</td><td>Sets the maximum number of items to return in the response.</td></tr>
     *     <tr><td>timeout</td><td>String</td><td>No</td><td>Sets the maximum time that the server can spend processing the request, in seconds. The default is 30 seconds.</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePages(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getMultiplePages(requestOptions));
    }

    /**
     * A paging operation that includes a next operation. It has a different query parameter from it's next operation
     * nextOperationWithQueryParams. Returns a ProductResult.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requiredQueryParameter A required integer query parameter. Put in value '100' to pass test.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getWithQueryParams(int requiredQueryParameter, RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getWithQueryParams(requiredQueryParameter, requestOptions));
    }

    /**
     * A paging operation that includes a nextLink in odata format that has 10 pages.
     *
     * <p><strong>Header Parameters</strong>
     *
     * <table border="1">
     *     <caption>Header Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>client-request-id</td><td>String</td><td>No</td><td>The clientRequestId parameter</td></tr>
     *     <tr><td>maxresults</td><td>String</td><td>No</td><td>Sets the maximum number of items to return in the response.</td></tr>
     *     <tr><td>timeout</td><td>String</td><td>No</td><td>Sets the maximum time that the server can spend processing the request, in seconds. The default is 30 seconds.</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     odataNextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getOdataMultiplePages(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getOdataMultiplePages(requestOptions));
    }

    /**
     * A paging operation that includes a nextLink that has 10 pages.
     *
     * <p><strong>Header Parameters</strong>
     *
     * <table border="1">
     *     <caption>Header Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>client-request-id</td><td>String</td><td>No</td><td>The clientRequestId parameter</td></tr>
     *     <tr><td>maxresults</td><td>String</td><td>No</td><td>Sets the maximum number of items to return in the response.</td></tr>
     *     <tr><td>timeout</td><td>String</td><td>No</td><td>Sets the maximum time that the server can spend processing the request, in seconds. The default is 30 seconds.</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param offset Offset of return value.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePagesWithOffset(int offset, RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getMultiplePagesWithOffset(offset, requestOptions));
    }

    /**
     * A paging operation that fails on the first call with 500 and then retries and then get a response including a
     * nextLink that has 10 pages.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePagesRetryFirst(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getMultiplePagesRetryFirst(requestOptions));
    }

    /**
     * A paging operation that includes a nextLink that has 10 pages, of which the 2nd call fails first with 500. The
     * client should retry and finish all 10 pages eventually.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePagesRetrySecond(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getMultiplePagesRetrySecond(requestOptions));
    }

    /**
     * A paging operation that receives a 400 on the first call.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getSinglePagesFailure(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getSinglePagesFailure(requestOptions));
    }

    /**
     * A paging operation that receives a 400 on the second call.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePagesFailure(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getMultiplePagesFailure(requestOptions));
    }

    /**
     * A paging operation that receives an invalid nextLink.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePagesFailureUri(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getMultiplePagesFailureUri(requestOptions));
    }

    /**
     * A paging operation that doesn't return a full URL, just a fragment.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     odataNextLink: String
     * }
     * }</pre>
     *
     * @param apiVersion Sets the api version to use.
     * @param tenant Sets the tenant to use.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePagesFragmentNextLink(
            String apiVersion, String tenant, RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getMultiplePagesFragmentNextLink(apiVersion, tenant, requestOptions));
    }

    /**
     * A paging operation that doesn't return a full URL, just a fragment with parameters grouped.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     odataNextLink: String
     * }
     * }</pre>
     *
     * @param apiVersion Sets the api version to use.
     * @param tenant Sets the tenant to use.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePagesFragmentWithGroupingNextLink(
            String apiVersion, String tenant, RequestOptions requestOptions) {
        return new PagedIterable<>(
                this.client.getMultiplePagesFragmentWithGroupingNextLink(apiVersion, tenant, requestOptions));
    }

    /**
     * A long-running paging operation that includes a nextLink that has 10 pages.
     *
     * <p><strong>Header Parameters</strong>
     *
     * <table border="1">
     *     <caption>Header Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>client-request-id</td><td>String</td><td>No</td><td>The clientRequestId parameter</td></tr>
     *     <tr><td>maxresults</td><td>String</td><td>No</td><td>Sets the maximum number of items to return in the response.</td></tr>
     *     <tr><td>timeout</td><td>String</td><td>No</td><td>Sets the maximum time that the server can spend processing the request, in seconds. The default is 30 seconds.</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     values: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getMultiplePagesLro(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getMultiplePagesLro(requestOptions));
    }

    /**
     * A paging operation that returns a paging model whose item name is is overriden by x-ms-client-name 'indexes'.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     indexes: [
     *         {
     *             properties: {
     *                 id: Integer
     *                 name: String
     *             }
     *         }
     *     ]
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the paginated response with {@link PagedIterable}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BinaryData> getPagingModelWithItemNameWithXmsClientName(RequestOptions requestOptions) {
        return new PagedIterable<>(this.client.getPagingModelWithItemNameWithXmsClientName(requestOptions));
    }
}
