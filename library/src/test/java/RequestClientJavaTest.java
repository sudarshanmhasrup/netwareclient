import netware.client.RequestClient;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class RequestClientJavaTest {

    @Test
    void networkRequest() {

        HashMap<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("x-api-key", "9CF4TaIX629gKf5Er767bR149OmVy71V5Pr5CI0v");

        RequestClient requestClient = new RequestClient(
                "http://localhost:3000",
                "GET",
                requestHeaders
        ).build();

        if (requestClient.isSuccess()) {
            assertEquals("Status: OK, Status Code: 200. \nResponse: {\"message\":\"API connection established successfully!\",\"status\":200}", requestClient.getResponse().getLog());
        } else {
            fail(requestClient.getError().getLog());
        }
    }
}
