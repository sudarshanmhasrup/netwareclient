import netware.client.RequestClient;

public class NetworkRequest {

    public static void main(String[] args) {

        RequestClient requestClient = new RequestClient(
                "http://localhost:3000",
                "GET"
        ).build();

        if (requestClient.isSuccess()) {
            System.out.println(requestClient.response().getLog(
                    false
            ));
        } else {
            System.out.println(requestClient.error().getLog());
        }
    }
}
