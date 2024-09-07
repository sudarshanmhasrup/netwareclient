import netware.client.RequestClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestClientKotlinTest {

    private val requestHeaders = mapOf("x-api-key" to "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v")

    @Test
    fun networkRequest() {

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "GET",
            headers = requestHeaders
        ).build()

        if (requestClient.isSuccess) {
            assertEquals("""
                Status: OK, Status Code: 200. 
                Response: {"message":"API connection established successfully!","status":200}
            """.trimIndent(), requestClient.getResponse().getLog())
        }
    }
}