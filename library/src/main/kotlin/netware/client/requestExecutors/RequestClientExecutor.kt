package netware.client.requestExecutors

import netware.client.dataHolders.ClientRequestError
import netware.client.dataHolders.ClientRequestResponse
import netware.client.dataHolders.ClientServerResponse
import java.net.HttpURLConnection
import java.net.URI
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.HttpsURLConnection.*

/*
    This class contains all the logic to send and handle an HTTP network request. It supports all standard HTTP network requests.
    It expects the server response to be in JSON form.
 */
internal class RequestClientExecutor(
    private val networkRequestURL: String,
    private val networkRequestMethod: String,
    private val networkRequestHeaders: Map<String, String>? = null
) {

    // Function to validate an HTTP request
    internal fun validateRequest(): ClientRequestResponse {
        return when {
            networkRequestURL.startsWith("http://") -> {
                requestExecutor(
                    isHTTPs = false
                )
            }
            networkRequestURL.startsWith("https://") -> {
                requestExecutor(
                    isHTTPs = true
                )
            }
            else -> {
                ClientRequestResponse(
                    isSuccess = false,
                    error = ClientRequestError(
                        statusCode = 1000,
                        status = "Failed",
                        error = "Invalid request protocol!"
                    )
                )
            }
        }
    }

    // Function to send HTTP requests
    internal fun requestExecutor(isHTTPs: Boolean): ClientRequestResponse {

        val networkRequestUri = URI(networkRequestURL)
        val networkRequestUrl = networkRequestUri.toURL()

        val networkRequestConnection = if (isHTTPs) {
            networkRequestUrl.openConnection() as HttpsURLConnection
        } else {
            networkRequestUrl.openConnection() as HttpURLConnection
        }

        networkRequestConnection.requestMethod = networkRequestMethod

        if (networkRequestHeaders != null) {
            for ((key, value) in networkRequestHeaders) {
                networkRequestConnection.setRequestProperty(key, value)
            }
        }

        try {

            // Read server response code and status
            val serverResponseStatusCode = networkRequestConnection.responseCode
            val serverResponseStatus = networkRequestConnection.responseMessage

            val serverResponse = if (serverResponseStatusCode in 200..299) {
                networkRequestConnection.inputStream.bufferedReader().use {
                    it.readText()
                }
            } else {
               networkRequestConnection.errorStream.bufferedReader().use {
                   it.readText()
               }
            }

            if (serverResponseStatusCode == HttpURLConnection.HTTP_OK) {
                return ClientRequestResponse(
                    isSuccess = true,
                    response = ClientServerResponse(
                        statusCode = serverResponseStatusCode,
                        status = serverResponseStatus,
                        response = serverResponse
                    )
                )
            } else {
                return ClientRequestResponse(
                    isSuccess = true,
                    response = ClientServerResponse(
                        statusCode = serverResponseStatusCode,
                        status = serverResponseStatus,
                        response = serverResponse
                    )
                )
            }
        } catch (exception: Exception) {
            return ClientRequestResponse(
                isSuccess = false,
                error = ClientRequestError(
                    statusCode = 200,
                    status = "Failed",
                    error = exception.toString()
                )
            )
        } finally {
            networkRequestConnection.disconnect()
        }
    }

}