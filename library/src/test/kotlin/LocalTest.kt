import netware.client.RequestClient
import netware.client.requestExtenstions.RequestClientHeaders
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class LocalTest {

    private val requestClientHeaders = RequestClientHeaders()

    // GET request on main URL
    @Test
    fun networkRequest() {

        requestClientHeaders.add("x-api-key", "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v")

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            headers = requestClientHeaders.getHeaders()
        ).build()

        if (requestClient.isSuccess) {
            assertEquals("""
                {"message":"API connection established successfully!","status":200}
            """.trimIndent(), requestClient.getResponse().getResponse())
        } else {
            fail(requestClient.getError().toString())
        }
    }

}