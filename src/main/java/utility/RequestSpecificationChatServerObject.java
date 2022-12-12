package utility;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utility.Config.getUrl;

public class RequestSpecificationChatServerObject {

    public static RequestSpecification getChatServerRequestSpecification() throws IOException {
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
        String fileName = "chat"+timeStamp+".txt";

        PrintStream log =new PrintStream(new FileOutputStream("log/"+fileName));

        RequestSpecification requestSpecificationChatServer
                = new RequestSpecBuilder()
                .setBaseUri(getUrl())
                .setAuth(auth)
                .addHeader("Content-Type", "application/json")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();

        return requestSpecificationChatServer;
    }
}
