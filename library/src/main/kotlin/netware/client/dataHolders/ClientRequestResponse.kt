package netware.client.dataHolders

// Data class holding response of an HTTP request
class ClientRequestResponse(
    private val isSuccess: Boolean,
    private val response: ClientServerResponse = ClientServerResponse(),
    private val error: ClientRequestError = ClientRequestError()
) {

    fun getResponse() = response
    fun getError() = error

    override fun toString(): String {
        return if (isSuccess) {
            """
            Status Code: ${response.getStatusCode()}. Status: ${response.getStatus()}.
            Response: ${response.getResponse()}
        """.trimIndent()
        } else {
            """
            Error Code: ${error.getStatusCode()}. Error Status: ${error.getStatus()}.
            Error: ${error.getError()}
        """.trimIndent()
        }
    }
}