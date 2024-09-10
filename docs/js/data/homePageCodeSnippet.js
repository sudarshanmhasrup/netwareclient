const homePageCodeSnippets = `import netware.client.RequestClient

fun networkRequest() {

    val requestClient = RequestClient(
        url = "http://localhost:3000",
        method = "GET"
    ).build()

    if (requestClient.isSuccess) {
        val response = requestClient.getResponse().getLog()
        println(response)

    } else {
        val error = requestClient.getError().getLog()
        println(error)
    }
}

fun main() {
    networkRequest()
}
`;

document.addEventListener("DOMContentLoaded", () => {
    
    const homeCodeSnippet = document.getElementById("home-page-code-snippet");
    homeCodeSnippet.innerHTML = homePageCodeSnippets;
});
