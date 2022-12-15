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
import utility.APIResource;
import utility.RequestSpecificationObject;

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
    RequestSpecification request;

    RequestSpecification getSingleUser;

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

        request = given().log().all().spec(RequestSpecificationObject.getRequestSpecificationObject())
                .body(getCreateUserObj("Amol5","HR5"));

    }
    @When("user calls createUser request using POST method call")
    public void user_calls_create_user_request_using_post_method_call() {

         response = request.when().post("/api/users");
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

        request = given().log().all().spec(getRequestSpecificationObject())
                .body(getUpdateUserObj("Amol6","HR6"));
    }

    @When("user calls updateUser request using PUT method call")
    public void userCallsUpdateUserRequestUsingPUTMethodCall() {

        response = request.when().put("/api/users/2");
    }

    @Given("Delete user payload is created")
    public void deleteUserPayloadIsCreated() throws IOException {

        request = given().log().all().spec(getRequestSpecificationObject());
    }

    @When("user calls deleteUser request using DELETE method call")
    public void userCallsDeleteUserRequestUsingDELETEMethodCall() {

        request.when().delete("/api/users/2");
    }

    @Given("Get All user payload is created")
    public void getAllUserPayloadIsCreated() throws IOException {

        request = given().log().all().spec(getRequestSpecificationObject())
                .queryParam("page", "2");
    }

    @When("user calls getAllUser request using GET method call")
    public void userCallsGetAllUserRequestUsingGETMethodCall() {

        response = request.when().get("/api/users");
    }


    @Given("^Create user payload is created with (.+) and (.+)$")
    public void createUserPayloadIsCreatedWithNameAndJob(String name , String job) throws IOException {
        request = given().log().all().spec(getRequestSpecificationObject())
                .body(getCreateUserObj(name,job));

    }


    @When("user calls {string} request using {string} method call")
    public void userCallsRequestUsingMethodCall(String requestType, String methodName) {

      /*  switch (requestType)
        {
            case "createUser" :  response = createUserRequest.when().post("/api/users"); break;
            case "updateUser" :  response = updateUserRequest.when().put("/api/users/2"); break;
            case "deleteUser" :  response = deleteUserRequest.when().delete("/api/users/2"); break;
            case "getAllUsers" :  response = getAllUsers.when().get("/api/users"); break;
        }*/
        APIResource apiResource =  APIResource.valueOf(requestType);
        System.out.println(apiResource.getResource()); // null

       switch (methodName)
        {
           case "GET" :  response = request.when().get(apiResource.getResource()); break;
            case "POST" :  response = request.when().post(apiResource.getResource()); break;
             case "PUT" :  response = request.when().put(apiResource.getResource()); break;
              case "DELETE" :  response = request.when().delete(apiResource.getResource()); break;
        }
    }

    @Given("Get single user payload is created")
    public void getSingleUserPayloadIsCreated() throws IOException {

        request = given().log().all().spec(getRequestSpecificationObject());
    }
}
