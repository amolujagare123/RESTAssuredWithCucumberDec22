package stepdefinitions;

import POJO.SampleUserCreateUpdatePojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import java.io.IOException;

import static POJO.PojoObject.SampleRest.getCreateUserObj;
import static POJO.PojoObject.SampleRest.getUpdateUserObj;
import static io.restassured.RestAssured.given;
import static utility.RequestSpecificationObject.getRequestSpecificationObject;

public class SampleRestSD {
    RequestSpecification createUserRequest;
    Response response;
    ResponseSpecification responseSpecBuilder;
    String responseStr;
    RequestSpecification updateUserRequest;
    RequestSpecification deleteUserRequest;
    RequestSpecification getAllUsers;

    @Given("Create user payload is created")
    public void create_user_payload_is_created() throws IOException {


      /*  RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type", "application/json")
                .build();

        createUserRequest = given().log().all().spec(requestSpecification)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"HR\"\n" +
                        "}");*/

       /* createUserRequest = given().log().all().spec(getRequestSpecificationObject())
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"HR\"\n" +
                        "}");*/

       /* SampleUserCreateUpdatePojo ob = new SampleUserCreateUpdatePojo();
        ob.setName("morpheus1");
        ob.setJob("HR1");

        createUserRequest = given().log().all().spec(getRequestSpecificationObject())
                .body(ob);*/

      /*  createUserRequest = given().log().all().spec(getRequestSpecificationObject())
                .body(getCreateUserObj());*/

        createUserRequest = given().log().all().spec(getRequestSpecificationObject())
                .body(getCreateUserObj("Amol5","HR5"));

    }
    @When("user calls createUser request using POST method call")
    public void user_calls_create_user_request_using_post_method_call() {

         response = createUserRequest.when().post("/api/users");
    }
    @Then("Request should be successful with status code {string}")
    public void request_should_be_successful_with_status_code(String statusCode) {

         responseSpecBuilder = new ResponseSpecBuilder()
                 .expectStatusCode(Integer.parseInt(statusCode))
         .build();

         try {
             responseStr = response.then().log().all().spec(responseSpecBuilder)
                     .extract().asString();
         }
         catch (Exception e)
         {
             response.then().log().all().spec(responseSpecBuilder);
             responseStr = "";
         }

    }

    @And("{string} should be {string}")
    public void shouldBe(String jsonPathOfNode, String expectedValue) {

        JsonPath jsonPath = new JsonPath(responseStr);
        String actual = jsonPath.get(jsonPathOfNode);

        Assert.assertEquals(actual,expectedValue,"value does not match");

    }

    @Given("Update user payload is created")
    public void updateUserPayloadIsCreated() throws IOException {




  /*       updateUserRequest = given().log().all().spec(getRequestSpecificationObject())
                                    .body("{\n" +
                                            "    \"name\": \"morpheus\",\n" +
                                            "    \"job\": \"zion resident\"\n" +
                                            "}");*/

      /*  SampleUserCreateUpdatePojo ob = new SampleUserCreateUpdatePojo();
        ob.setName("morpheus2");
        ob.setJob("HR2");

        updateUserRequest = given().log().all().spec(getRequestSpecificationObject())
                .body(ob);*/

      /*  updateUserRequest = given().log().all().spec(getRequestSpecificationObject())
                .body(getUpdateUserObj());*/

        updateUserRequest = given().log().all().spec(getRequestSpecificationObject())
                .body(getUpdateUserObj("Amol6","HR6"));
    }

    @When("user calls updateUser request using PUT method call")
    public void userCallsUpdateUserRequestUsingPUTMethodCall() {

        response = updateUserRequest.when().put("/api/users/2");
    }

    @Given("Delete user payload is created")
    public void deleteUserPayloadIsCreated() throws IOException {

         deleteUserRequest = given().log().all().spec(getRequestSpecificationObject());
    }

    @When("user calls deleteUser request using DELETE method call")
    public void userCallsDeleteUserRequestUsingDELETEMethodCall() {

        deleteUserRequest.when().delete("/api/users/2");
    }

    @Given("Get All user payload is created")
    public void getAllUserPayloadIsCreated() throws IOException {

         getAllUsers = given().log().all().spec(getRequestSpecificationObject())
                .queryParam("page", "2");
    }

    @When("user calls getAllUser request using GET method call")
    public void userCallsGetAllUserRequestUsingGETMethodCall() {

        response = getAllUsers.when().get("/api/users");
    }
}
