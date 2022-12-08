package stepdefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static utility.RequestSpecificationChatServerObject.getChatServerRequestSpecification;

public class ChatUserSD {

    RequestSpecification requestSpecChatServer;
    Response response;
    ResponseSpecification responseSpecChatServer;
    String responseStr;
    @Given("create chat user payload is created")
    public void create_chat_user_payload_is_created() {


         requestSpecChatServer = given().log().all().spec(getChatServerRequestSpecification()).body("{\n" +
                "  \"username\": \"anuja\",\n" +
                "  \"password\": \"anuja123\",\n" +
                "  \"email\": \"anuja@example.org\",\n" +
                "  \"name\": \"Anuja\",\n" +
                "  \"surname\": \"Gore\",\n" +
                "  \"chat_nickname\": \"anu\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}");

    }
    @When("user calls createChatUser request using POST method call")
    public void user_calls_create_chat_user_request_using_post_method_call() {
         response = requestSpecChatServer.when().post("/restapi/user");
    }
    @Then("Chat user Request should be successful with status code {string}")
    public void chat_user_request_should_be_successful_with_status_code(String statusCode) {

        responseSpecChatServer = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(statusCode)).build();

         responseStr = response.then().log().all().spec(responseSpecChatServer).extract().asString();

    }
    @Then("{string} should be {string};")
    public void should_be(String pathOfNode, String expectedValue) {

        JsonPath jsonPath = new JsonPath(responseStr);

        String actual = jsonPath.get(pathOfNode);

        System.out.println("expectedValue="+expectedValue);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expectedValue,"value does not match");

    }

    @Given("update chat user payload is created")
    public void updateChatUserPayloadIsCreated() {

        requestSpecChatServer = given().log().all().spec(getChatServerRequestSpecification()).body("{\n" +
                "  \"username\": \"anu1234\",\n" +
                "  \"password\": \"anuja123\",\n" +
                "  \"email\": \"anuja@example.org\",\n" +
                "  \"name\": \"Anuja\",\n" +
                "  \"surname\": \"Gore\",\n" +
                "  \"chat_nickname\": \"anu\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}");
    }

    @When("user calls updateChatUser request using PUT method call with user id {string}")
    public void userCallsUpdateChatUserRequestUsingPUTMethodCallWithUserId(String userId) {
        response = requestSpecChatServer.when().put("/restapi/user/"+userId);
    }

    @Given("delete chat user payload is created")
    public void deleteChatUserPayloadIsCreated() {

        requestSpecChatServer = given().log().all().spec(getChatServerRequestSpecification());
    }

    @When("user calls deleteChatUser request using DELETE method call with user id {string}")
    public void userCallsDeleteChatUserRequestUsingDELETEMethodCallWithUserId(String userId) {
        response = requestSpecChatServer.when().delete("/restapi/user/"+userId);
    }

    @Then("{string} should be a boolean value {string};")
    public void shouldBeABooleanValue(String pathOfNode, String expectedValue) {

        JsonPath jsonPath = new JsonPath(responseStr);

        boolean actual = jsonPath.get(pathOfNode);
        boolean expected = Boolean.parseBoolean(expectedValue);
        System.out.println("expectedValue="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"value does not match");

    }

    @Given("getSingle chat user payload is created")
    public void getsingleChatUserPayloadIsCreated() {
        requestSpecChatServer = given().log().all().spec(getChatServerRequestSpecification());
    }

    @When("user calls getSingleChatUser request using get method call with user id {string}")
    public void userCallsGetSingleChatUserRequestUsingGetMethodCallWithUserId(String userId) {
        response = requestSpecChatServer.when().get("/restapi/user/"+userId);
    }

    @Then("{string} should be a Integer value {string};")
    public void shouldBeAIntegerValue(String pathOfNode, String expectedValue) {

        JsonPath jsonPath = new JsonPath(responseStr);

        int actual = jsonPath.get(pathOfNode);
        int expected = Integer.parseInt(expectedValue);
        System.out.println("expectedValue="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"value does not match");

    }
}
