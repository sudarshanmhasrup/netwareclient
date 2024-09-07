package netware.client.requestExecutors

import netware.client.dataHolders.ClientRequestResponse
import netware.client.dataHolders.ClientServerResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestClientExecutorTest {

    @Test
    fun requestExecutorTest() {

        val requestClientExecutor = RequestClientExecutor(
            networkRequestURL = "http://localhost:3000/",
            networkRequestMethod = "GET"
        ).requestExecutor(
            isHTTPs = false
        )

        val expectedResponse = ClientServerResponse(
            statusCode = 200,
            status = "OK",
            response = "{\"message\":\"API connection successful!\",\"status\":200}"
        )

        assertEquals(expectedResponse, requestClientExecutor.getResponse())
    }
}
