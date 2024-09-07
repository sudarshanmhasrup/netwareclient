import netware.client.RequestClient
import netware.client.dataHolders.ClientRequestError
import netware.client.dataHolders.ClientServerResponse
import netware.client.requestCallbacks.ClientCallback
import org.json.JSONObject

class NetworkRequest {

    fun sendNetworkRequest() {

        val requestClient = RequestClient(
            url = "https://api.freeapi.app/api/v1/public/randomusers?page=1&limit=10",
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