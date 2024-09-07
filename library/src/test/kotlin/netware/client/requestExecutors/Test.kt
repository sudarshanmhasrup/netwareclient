package netware.client.requestExecutors

import netware.client.dataHolders.ClientRequestResponse
import org.junit.Test

class Test {

    @Test
    fun requestExecutor() {

        val requestClientExecutor = RequestClientExecutor(
            networkRequestURL = "http://localhost:3000/",
            networkRequestMethod = "GET"
        ).requestExecutor(
            isHTTPs = false
        )

        println(requestClientExecutor)

    }
}