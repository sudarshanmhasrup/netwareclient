package netware.client

import netware.client.dataHolders.ClientRequestError
import netware.client.dataHolders.ClientServerResponse
import netware.client.requestCallbacks.ClientCallback
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

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
            """.trimIndent(), requestClient.response().getLog())
        }
    }

    @Test
    fun networkRequestWithCallback() {

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "GET",
            headers = requestHeaders
        ).build(object: ClientCallback {
            override fun onSuccess(response: ClientServerResponse) {
                assertEquals("""
                    Status: OK, Status Code: 200. 
                    Response: {"message":"API connection established successfully!","status":200}
                """.trimIndent(), response.getLog())
            }

            override fun onError(error: ClientRequestError) {
                fail {
                    error.getLog()
                }
            }

        })
    }
}