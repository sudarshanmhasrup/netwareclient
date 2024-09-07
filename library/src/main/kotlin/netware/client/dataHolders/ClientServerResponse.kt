package netware.client.dataHolders

// Data class holding server response of an HTTP request
data class ClientServerResponse(
    private val statusCode: Int = 0,
    private val status: String = "No status found.",
    private val response: String = "No response found"
) {

    fun getStatusCode() = statusCode
    fun getStatus() = status
    fun getResponse() = response
}