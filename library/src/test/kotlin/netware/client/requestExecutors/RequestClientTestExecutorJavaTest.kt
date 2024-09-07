package netware.client.requestExecutors

import netware.client.dataHolders.ClientServerResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestClientTestExecutorJavaTest {

    private val requestHeaders = mapOf("x-api-key" to "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v")

    private val expectedResponse = ClientServerResponse(
        statusCode = 200,
        status = "OK",
        response = """{"message":"API connection established successfully!","status":200}"""
    )

    @Test
    fun validateRequestTest() {

        val requestClientExecutor = RequestClientExecutor(
            networkRequestURL = "http://localhost:3000/",
            networkRequestMethod = "GET",
            networkRequestHeaders = requestHeaders
        ).validateRequest()

        assertEquals(expectedResponse, requestClientExecutor.getResponse())
    }

    @Test
    fun requestExecutorTest() {

        val requestClientExecutor = RequestClientExecutor(
            networkRequestURL = "http://localhost:3000/",
            networkRequestMethod = "GET",
            networkRequestHeaders = requestHeaders
        ).requestExecutor(
            isHTTPs = false
        )

        assertEquals(expectedResponse, requestClientExecutor.getResponse())
    }

}
