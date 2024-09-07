package netware.client.requestCallbacks

import netware.client.dataHolders.ClientRequestError
import netware.client.dataHolders.ClientServerResponse

// Request Client callback
interface ClientCallback {

    fun onSuccess(response: ClientServerResponse) {}
    fun onError(error: ClientRequestError) {}
}