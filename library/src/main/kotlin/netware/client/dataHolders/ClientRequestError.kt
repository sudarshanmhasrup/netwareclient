package netware.client.dataHolders

// Data class holding error of an HTTP request
data class ClientRequestError(
    private val statusCode: Int = 0,
    private val status: String = "No status found",
    private val error: String = "No error found."
) {

    fun getStatusCode() = statusCode
    fun getStatus() = status
    fun getError() = error
    fun getLog() = "Error Status: $status, Error Status Code: $statusCode. \nError: $error"
}