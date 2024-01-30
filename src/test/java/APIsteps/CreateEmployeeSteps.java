package APIsteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import org.junit.runner.Request;
import utils.APIconstants;
import utils.APIpayloadBodyConstants;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateEmployeeSteps {
    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("a request is prepared for generating employee")
    public void a_request_is_prepared_for_generating_employee() {
       request= RestAssured.given().header(APIconstants.HEADER_CONTENT_TYPE
        ,APIconstants.CONTENT_TYPE).header(APIconstants.HEADER_AUTHORIZATION,generateTokenSteps.token).
                body(APIpayloadBodyConstants.createEmployeePayload());
        System.out.println("Request Payload: " + APIpayloadBodyConstants.createEmployeePayload());
    }

    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response=request.when().post(APIconstants.CREATE_EMPLOYEE_URI);
        response.prettyPrint();
    }
    @Then("status code to create an employee is {int}")
    public void status_code_to_create_an_employee_is(int statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }
    @Then("the created employee should contains as a key {string} and value {string}")
    public void the_created_employee_should_contains_as_a_key_and_value(String message, String messagevalue) {
        response.then().body(message,equalTo(messagevalue));
    }

    @Then("the employee id {string} is stored as global variable to be used for other calls")
    public void the_employee_id_is_stored_as_global_variable_to_be_used_for_other_calls(String empID) {
        employee_id =response.jsonPath().getString(empID);
        System.out.println(employee_id);
    }
    //----------------------------------------------------------------

    @Given("a request is prepared to get the created employee by using api call")
    public void a_request_is_prepared_to_get_the_created_employee_by_using_api_call() {
        request=given().header(APIconstants.HEADER_CONTENT_TYPE,APIconstants.CONTENT_TYPE)
                .header(APIconstants.HEADER_AUTHORIZATION,generateTokenSteps.token).queryParam("employee_id",employee_id);

    }
    @When("a get call is made to retrieve the created employees")
    public void a_get_call_is_made_to_retrieve_the_created_employees() {
        response=request.when().get(APIconstants.GET_ONE_EMPLOYEE_URI);

    }
    @Then("the status code for this employee is {int}")
    public void the_status_code_for_this_employee_is(int status) {
        response.then().assertThat().statusCode(status);
        System.out.println("Actual Status Code: " + response.getStatusCode());

    }
    @Then("the employee data we get having ID {string} this should be matched with globally stored employee id")
    public void the_employee_data_we_get_having_id_this_should_be_matched_with_globally_stored_employee_id(String empidTemp) {response.jsonPath().getString(empidTemp);
//        response.jsonPath().getString(empidTemp);
//        Assert.assertEquals(empidTemp,employee_id);
        String actualEmployeeId = response.jsonPath().getString(empidTemp);
        Assert.assertEquals(employee_id, actualEmployeeId);
    }
    @Then("the retrieved data at {string} object matches the data used to create an employee with employee id {string}")
    public void the_retrieved_data_at_object_matches_the_data_used_to_create_an_employee_with_employee_id
            (String employeobject, String responseemployeid, DataTable dataTable) {

        List<Map<String,String>> expectedata= dataTable.asMaps(String.class,String.class);
        Map<String,String>  actualdata=response.jsonPath().get(employeobject);
        for (Map<String,String> map:expectedata
        ) {
            Set<String> allkeys=map.keySet();
            for(String singlekey:allkeys){
                // these lines compring the valuses that the featrues file values are equal to the response body values only
                // keys are comparing with featrue and response body
                String  ExpectedValue=map.get(singlekey);
                String actualValue=actualdata.get(singlekey);
                Assert.assertEquals(ExpectedValue, actualValue);
            }
        }
        // these lines check that while creating employe , the generated id is equal to the id while getting one eomployee
        String empID=response.body().jsonPath().getString(responseemployeid);
        Assert.assertEquals(empID,employee_id);


    }



}
