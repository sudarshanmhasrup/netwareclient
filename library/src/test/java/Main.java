import netware.client.RequestClient;

public class Main {
    public static void main(String args[]) {

        RequestClient requestClient = new RequestClient(
                "http://localhost:3000"
        ).build();
        
        if (requestClient.isSuccess()) {
            System.out.println("Network request successful!");
        } else {
            System.out.println("Network request unsuccessful!");
        }
    }
}
