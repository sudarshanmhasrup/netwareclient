import netware.client.RequestClient
import netware.client.requestDefaults.requestClientHeader

fun main() {

    val requestClient = RequestClient(
        url = "https://localhost:3000",
    ).build()



}