package utility;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationChatServerObject {

    public static RequestSpecification getChatServerRequestSpecification()
    {
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestSpecificationChatServer
                = new RequestSpecBuilder()
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin")
                .setAuth(auth)
                .addHeader("Content-Type", "application/json").build();

        return requestSpecificationChatServer;
    }
}
