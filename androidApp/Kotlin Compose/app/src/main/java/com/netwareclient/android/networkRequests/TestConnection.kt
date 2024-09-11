package com.netwareclient.android.networkRequests

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import netware.client.RequestClient
import netware.client.dataHolders.ClientRequestError
import netware.client.dataHolders.ClientServerResponse
import netware.client.requestCallbacks.ClientCallback
import netware.client.requestExtenstions.RequestClientHeaders


class TestConnection {

    internal fun networkRequest() {

        CoroutineScope(Dispatchers.IO).launch {

            val requestClientHeaders = RequestClientHeaders()
            requestClientHeaders.add("x-api-key", "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v")

            val requestClient = RequestClient(
                url = "https://www.instagram.com",
                method = "GET",
                headers = requestClientHeaders.getHeaders()
            ).build(object : ClientCallback {

                override fun onSuccess(response: ClientServerResponse) {
                    Log.d("network-request", response.getLog())
                }

                override fun onError(error: ClientRequestError) {
                    Log.d("network-request", error.getLog())
                }
            })
        }
    }
}

fun main() {

    val networkTest = TestConnection()
    networkTest.networkRequest()
}