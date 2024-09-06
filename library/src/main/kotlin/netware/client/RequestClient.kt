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

    // Constructor 1
    constructor(url: String, method: String): this(url) {
        networkRequestMethod = method
    }

    // Function to execute the network request
    fun build() {

    }
}