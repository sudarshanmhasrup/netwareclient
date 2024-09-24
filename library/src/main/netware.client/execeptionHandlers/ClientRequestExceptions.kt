package netware.client.execeptionHandlers

import netware.client.dataHolders.ClientRequestError
import java.lang.Exception

internal fun clientRequestExceptionDecoder(exception: Exception): ClientRequestError {
    return when (exception) {
        is java.net.ConnectException -> ClientRequestError(
            status = "Failed",
            statusCode = 1009,
            error = "Failed to connect to the server."
        )
        is java.net.SocketTimeoutException -> ClientRequestError(
            status = "Failed",
            statusCode = 1010,
            error = "Connection timed out."
        )
        is java.net.UnknownHostException -> ClientRequestError(
            status = "Failed",
            statusCode = 1011,
            error = "Unknown host."
        )
        is javax.net.ssl.SSLException -> ClientRequestError(
            status = "Failed",
            statusCode = 1013,
            error = "SSL handshake failed."
        )
        is java.net.ProtocolException -> ClientRequestError(
            status = "Failed",
            statusCode = 1015,
            error = "Protocol error."
        )
        is java.net.MalformedURLException -> ClientRequestError(
            status = "Failed",
            statusCode = 1014,
            error = "Malformed URL."
        )
        is java.io.IOException -> ClientRequestError(
            status = "Failed",
            statusCode = 1012,
            error = "I/O error occurred."
        )
        else -> ClientRequestError(
            status = "Failed",
            statusCode = 1099,
            error = "$exception"
        )
    }
}
