package netware.client.requestExecutors

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


    }
}