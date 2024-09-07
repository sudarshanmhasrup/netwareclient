package netware.client.requestExecutors

import netware.client.dataHolders.ClientRequestResponse
import netware.client.dataHolders.ClientServerResponse
import java.net.HttpURLConnection
import java.net.URI
import javax.net.ssl.HttpsURLConnection

/*
    This class contains all the logic to send and handle an HTTP network request. It supports all standard HTTP network requests.
    It expects the server response to be in JSON form.
 */
internal class RequestClientExecutor(
    private val networkRequestURL: String,
    private val networkRequestMethod: String
) {


    // Function to send an HTTP request
    fun requestExecutor(isHTTPs: Boolean): ClientRequestResponse {

        val networkRequestUri = URI(networkRequestURL)
        val networkRequestUrl = networkRequestUri.toURL()

        val networkRequestConnection = if (isHTTPs) {
            networkRequestUrl.openConnection() as HttpsURLConnection
        } else {
            networkRequestUrl.openConnection() as HttpURLConnection
        }

        networkRequestConnection.requestMethod = networkRequestMethod

        try {

            // Read server response code and status
            val serverResponseStatusCode = networkRequestConnection.responseCode
            val serverResponseStatus = networkRequestConnection.responseMessage

            val inputStream = if (serverResponseStatusCode in 200..299) {
                networkRequestConnection.inputStream
            } else {
                networkRequestConnection.errorStream
            }

            val serverResponse = inputStream.bufferedReader().use {
                it.readText()
            }

            return ClientRequestResponse(
                isSuccess = true,
                response = ClientServerResponse(
                    statusCode = serverResponseStatusCode,
                    status = serverResponseStatus,
                    response = serverResponse
                )
            )

        } catch (exception: Exception) {
            println(exception)
        } finally {
            networkRequestConnection.disconnect()
        }


    }

}