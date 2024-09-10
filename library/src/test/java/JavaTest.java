import netware.client.RequestClient;
import netware.client.requestExtenstions.RequestClientHeaders;

public class JavaTest {
    public static void main(String[] args) {

        RequestClientHeaders requestClientHeaders = new RequestClientHeaders();
        requestClientHeaders.add("x-api-key", "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v");

        RequestClient requestClient = new RequestClient(
                "http://localhost:3000",
                requestClientHeaders.getHeaders()
        ).build();

        if (requestClient.isSuccess()) {
            System.out.println(requestClient.getResponse().getLog());
        } else {
            System.out.println(requestClient.getResponse().getLog());
        }
    }
}
