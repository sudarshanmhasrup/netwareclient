package netware.client

import netware.client.dataHolders.ClientRequestError
import netware.client.dataHolders.ClientServerResponse
import netware.client.requestCallbacks.ClientCallback
import netware.client.requestExecutors.RequestClientExecutor

/*
    This class is used to send network requests, which are plain HTTP requests.It supports following method: "GET", "POST", "PATCH", "UPDATE" and "DELETE".
    It uses HttpUrlConnection and HttpsUrlConnection under the hood for making network requests.
 */
@Suppress("unused")
class RequestClient(
    url: String
) {

    private val networkRequestUrl = url
    private var networkRequestMethod = "GET" // GET is the default request method
    private var networkRequestHeaders: MutableMap<String, String> = mutableMapOf()

    var isSuccess = false

    private var response: ClientServerResponse = ClientServerResponse()
    private var error: ClientRequestError = ClientRequestError()

    constructor(url: String, method: String): this(url) {
        networkRequestMethod = method
    }

    constructor(url: String, method: String, headers: Map<String, String>): this (url) {
        networkRequestMethod = method
        networkRequestHeaders += headers
    }

    constructor(url: String, headers: Map<String, String>): this(url) {
        networkRequestHeaders += headers
    }

    // Getter function for server response and error
    fun getResponse() = response
    fun getError() = error

    fun build(clientCallback: ClientCallback? = null): RequestClient {

        if (networkRequestMethod in listOf("GET", "POST", "PATCH", "DELETE", "UPDATE")) {
            // Initialize and execute the network request
            val requestClientExecutor = RequestClientExecutor(
                networkRequestURL = networkRequestUrl,
                networkRequestMethod = networkRequestMethod,
                networkRequestHeaders = networkRequestHeaders
            ).validateRequest()

            if (requestClientExecutor.isSuccess) {
                isSuccess = true
                clientCallback?.onSuccess(
                    response = requestClientExecutor.getResponse()
                )
            } else {
                isSuccess = false
                clientCallback?.onError(
                    error = requestClientExecutor.getError()
                )
            }
        } else {

            clientCallback?.onError(
                error = ClientRequestError(
                    statusCode = 1000,
                    status = "Failed",
                    error = "The method \"$networkRequestMethod\" is not a valid HTTP request method."
                )
            )
        }

        return this
    }

    fun build(): RequestClient {

        if (networkRequestMethod in listOf("GET", "POST", "PATCH", "DELETE", "UPDATE")) {

            // Initialize and execute the network request
            val requestClientExecutor = RequestClientExecutor(
                networkRequestURL = networkRequestUrl,
                networkRequestMethod = networkRequestMethod,
                networkRequestHeaders = networkRequestHeaders
            ).validateRequest()

            if (requestClientExecutor.isSuccess) {
                isSuccess = true
                response = requestClientExecutor.getResponse()
            } else {
                isSuccess = false
                error = requestClientExecutor.getError()
            }
        } else {

            isSuccess = false
            error = ClientRequestError(
                statusCode = 1000,
                status = "Failed",
                error = "The method \"$networkRequestMethod\" is not a valid HTTP request method."
            )
        }

        return this
    }
}

