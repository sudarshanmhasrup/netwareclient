import netware.client.RequestClient
import netware.client.dataHolders.ClientRequestError
import netware.client.dataHolders.ClientServerResponse
import netware.client.requestCallbacks.ClientCallback

class NetworkRequest {

    fun sendNetworkRequest() {
        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "GET"
        ).build(object : ClientCallback {
            override fun onSuccess(response: ClientServerResponse) {
                println(response.getLog())
            }

            override fun onError(error: ClientRequestError) {
                println(error.getLog())
            }
        })
    }
}

fun main() {

    val networkRequest = NetworkRequest()
    networkRequest.sendNetworkRequest()
}