import netware.client.RequestClient
import netware.client.requestExtenstions.RequestClientHeaders

fun networkRequest() {

    val requestClientHeaders = RequestClientHeaders()
    requestClientHeaders.add("x-api-key", "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v")

    val requestClient = RequestClient(
        url = "http://localhost:3000",
        method = "GET",
        headers = requestClientHeaders.getHeaders()
    ).build()

    if (requestClient.isSuccess) {
        println(
            requestClient.response().getLog(
                formatResponse = true
            )
        )
    } else {
        println(requestClient.error().getLog())
    }
}

fun main() {

    networkRequest()
}