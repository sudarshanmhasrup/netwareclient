package netware.client.dataHolders
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Suppress("unused")
// Data class holding server response of an HTTP request
data class ClientServerResponse(
    private val statusCode: Int = 0,
    private val status: String = "No status found",
    private val response: String = "No response found.",
    private val responseHeaders: Map<String, String> = mapOf()
) {

    fun getStatusCode() = statusCode
    fun getStatus() = status
    fun getResponse() = response
    fun getHeaders() = responseHeaders

    // Function to show log
    fun getLog(formatResponse: Boolean = false): String {

        val prettyResponse = formatResponse(response)

        if (formatResponse) {
            return """

Status: $status, Status Code: $statusCode.
Response: -----------------------------------------------
$prettyResponse
---------------------------------------------------------
""".trimIndent()

        } else {
            return """
                Status: $status, Status Code: $statusCode.
                Response: $response
            """
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun formatResponse(response: String): String {

        val prettyJson = Json {
            prettyPrint = true
            prettyPrintIndent = "  "
        }

        val jsonElement = Json.parseToJsonElement(response)

        return prettyJson.encodeToString(jsonElement)
    }
}