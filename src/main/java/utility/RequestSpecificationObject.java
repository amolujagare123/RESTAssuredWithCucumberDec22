package utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static utility.Config.getSampleRestUrl;

public class RequestSpecificationObject {

    public static RequestSpecification getRequestSpecificationObject() throws IOException {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(getSampleRestUrl())
                .addHeader("Content-Type", "application/json")
                .build();

        return requestSpecification;
    }
}
