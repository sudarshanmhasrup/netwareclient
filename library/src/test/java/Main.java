import netware.client.RequestClient;

public class Main {
    public static void main(String args[]) {

        RequestClient requestClient = new RequestClient(
                "http://localhost:3000"
        ).build();
        
        if (requestClient.isSuccess()) {
            System.out.println(requestClient.getResponse().getResponse());
        } else {
            System.out.println(requestClient.getError().getError());
        }
    }
}
