package netware.client.dataHolders

import org.json.JSONObject

// Data class holding server response of an HTTP request
data class ClientServerResponse(
    private val statusCode: Int = 0,
    private val status: String = "No status found",
    private val response: String = "No response found."
) {

    fun getStatusCode() = statusCode
    fun getStatus() = status
    fun getResponse() = response
    fun getLog() = "Status: $status, Status Code: $statusCode. \nResponse: $response"

    // Function to return an object from response
    fun getObject(key: String): String {
        val jsonObjectResponse = JSONObject(response)
        val result = jsonObjectResponse.getJSONObject(key)

        return result.toString()
    }
}