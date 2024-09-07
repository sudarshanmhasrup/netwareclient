import netware.client.RequestClient

fun main() {

    val apiKey = System.getenv("API_KEY")
    val requestHeaders = mapOf("x-api-key" to "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v")

    val requestClient = RequestClient(
        url = "http://localhost:3000/get/hello-world",
        method = "XXX",
        headers = requestHeaders
    ).build()

    if (requestClient.isSuccess) {
        println(requestClient.getResponse().getResponse())
    } else {
        println(requestClient.getError().getError())
    }

}