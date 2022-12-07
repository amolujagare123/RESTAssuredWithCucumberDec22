package utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationObject {

    public static RequestSpecification getRequestSpecificationObject()
    {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type", "application/json")
                .build();

        return requestSpecification;
    }
}
