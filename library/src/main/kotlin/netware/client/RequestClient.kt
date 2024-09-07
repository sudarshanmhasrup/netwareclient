package netware.client

/*
    This class is used to send network requests, which are plain HTTP requests.
    It supports the following method requests: `GET`, `Post`, `Patch`, `Delete`.

    It uses HttpUrlConnection and HttpsUrlConnection under the hood for making network requests.
 */
class RequestClient constructor(
    url: String
) {

    private val networkRequestUrl = url
    private var networkRequestMethod = "GET" // GET is the default request method
    private var networkRequestHeaders: MutableMap<String, String> = mutableMapOf()

    var isSuccess = false

    constructor(url: String, method: String): this(url) {
        networkRequestMethod = method
    }

    constructor(url: String, method: String, headers: Map<String, String>): this (url) {
        networkRequestMethod = method
        networkRequestHeaders += headers
    }

    constructor(url: String, headers: Map<String, String>): this(url) {
        networkRequestHeaders += headers
    }


    // Function to execute the network request
    fun build(): RequestClient {

        println(networkRequestHeaders)
        return this
    }
}