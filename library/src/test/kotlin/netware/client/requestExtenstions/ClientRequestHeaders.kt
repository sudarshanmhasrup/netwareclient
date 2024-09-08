package netware.client.requestExtenstions

import netware.client.RequestClient
import netware.client.dataHolders.ClientRequestError
import netware.client.dataHolders.ClientServerResponse
import netware.client.requestCallbacks.ClientCallback
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

class RequestClientHeadersTest {

    @Test
    fun requestClientHeadersExtender() {


        val requestClientHeaders = RequestClientHeaders()
        requestClientHeaders.add("Accept", "application/json")
        requestClientHeaders.add("Content-Type", "application/json")

        val exceptedMap = mapOf(
            "Accept" to "application/json",
            "Content-Type" to "application/json"
        )

        assertEquals(exceptedMap, requestClientHeaders.getHeaders())
    }

    @Test
    fun networkRequestWithHeaders() {

        val requestClientHeaders = RequestClientHeaders()
        requestClientHeaders.add("Accept", "application/json")
        requestClientHeaders.add("Content-Type", "application/json")
        requestClientHeaders.add("x-api-key", "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v")

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "GET",
            headers = requestClientHeaders.getHeaders()
        ).build(object: ClientCallback {
            override fun onSuccess(response: ClientServerResponse) {
                assertEquals(
                    """
                    Status: OK, Status Code: 200. 
                    Response: {"message":"API connection established successfully!","status":200}
                """.trimIndent(), response.getLog()
                )
            }

            override fun onError(error: ClientRequestError) {
                org.junit.jupiter.api.fail {
                    error.getLog()
                }
            }
        })
    }
}