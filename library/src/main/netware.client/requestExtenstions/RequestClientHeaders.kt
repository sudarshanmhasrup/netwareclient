package netware.client.requestExtenstions

// HTTP network request headers (extension) for ease of use
class RequestClientHeaders {

    private val clientRequestHeaders: MutableMap<String, String> = mutableMapOf()

    fun add(key: String, value: String) {
        clientRequestHeaders[key] = value
    }

    fun getHeaders() = clientRequestHeaders
}