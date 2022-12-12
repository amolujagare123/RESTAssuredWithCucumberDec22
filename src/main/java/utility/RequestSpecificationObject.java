package utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utility.Config.getSampleRestUrl;

public class RequestSpecificationObject {


    public static RequestSpecification getRequestSpecificationObject() throws IOException {

        String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
        String fileName = "Sample"+timeStamp+".txt";

        PrintStream log = new PrintStream(new FileOutputStream("log/"+fileName));

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(getSampleRestUrl())
                .addHeader("Content-Type", "application/json")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();

        return requestSpecification;
    }
}
