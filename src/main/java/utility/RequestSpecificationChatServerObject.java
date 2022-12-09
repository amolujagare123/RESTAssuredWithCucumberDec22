package utility;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static utility.Config.getUrl;

public class RequestSpecificationChatServerObject {

    public static RequestSpecification getChatServerRequestSpecification() throws IOException {
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestSpecificationChatServer
                = new RequestSpecBuilder()
                .setBaseUri(getUrl())
                .setAuth(auth)
                .addHeader("Content-Type", "application/json").build();

        return requestSpecificationChatServer;
    }
}
