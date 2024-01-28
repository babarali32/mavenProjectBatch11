package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class hardcodedexample {
    // this @test is annotation in junit to Run any method ,
    // storing the base uri
    String BaseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDY0MzMwODAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwNjQ3NjI4MCwidXNlcklkIjoiNjM5NSJ9.Of4hqkeLs0FAssVTAFzB6aCgOdiUtRS2HSFGWvNNjfI";
    String employe_id;
    @Test
    public void bgetEmployee() {
        // preparaing the request to get an employee
        RequestSpecification preparedrequest = given().header("Content-Type", "application/json")
                .header("Authorization", token)
                .queryParam("employee_id", employe_id);
        // now above request is prepared do not perform action on this request, in get provide endpoint from swagger.
        // this request will give response , where we will save response -- preparedquest.when().get("/getOneEmployee.php");
        Response response = preparedrequest.when().get("/getOneEmployee.php");
        // response in terms of string please print
        //from convert any thing from java , we use to String method
        // this is converting from json to string thats why this is using as string
        // System.out.println(response.asString());
        // this pretty print does same as println in java
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        String empID=response.jsonPath().getString("employee.employee_id");
        boolean comapringempid=empID.contentEquals(employe_id);
        Assert.assertTrue(comapringempid);
        String firstname=response.jsonPath().getString("employee.emp_firstname");
        System.out.println(firstname);
        Assert.assertTrue(firstname.contentEquals("kangro1"));
    }
    @Test
    public void acreatEmployee() {
        RequestSpecification preparedrequest = RestAssured.given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"kangro1\",\n" +
                        "  \"emp_lastname\": \"kangro8\",\n" +
                        "  \"emp_middle_name\": \"kangro67\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2020-02-20\",\n" +
                        "  \"emp_status\": \"unemployee\",\n" +
                        "  \"emp_job_title\": \"maali\"\n" +
                        "}");
        Response response = preparedrequest.when().post("/createEmployee.php");
        //this is used to print the response
        response.prettyPrint();
        // here below lines mean , jsonpath is method which has object Employee and employee has
        // all information about created employee in the form of json we have to convert it in string method
        // so use to string .
        //we use a method jsonpath() to get specific information from json object
        employe_id = response.jsonPath().getString("Employee.employee_id");
        // STORE INSIDE A STRING
        System.out.println(employe_id);
        // these assertion are coming  from hamcrest mathcers
        response.then().statusCode(201);
        // Assuming "response" is an object representing the HTTP response
        response.then().body("Employee.emp_firstname", equalTo("kangro1"));
        response.then().body("Message",equalTo("Employee Created"));
       response.then().header("Server",equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));

    }
    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedrequest=given().header("Authorization",token).
                header("Content-Type", "application/json").body("{\n" +
                        "  \"employee_id\": \""+employe_id+"\",\n" +
                        "  \"emp_firstname\": \"run2\",\n" +
                        "  \"emp_lastname\": \"run3\",\n" +
                        "  \"emp_middle_name\": \"run4\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2000-10-22\",\n" +
                        "  \"emp_status\": \"running\",\n" +
                        "  \"emp_job_title\": \"prime Minister\"\n" +
                        "}");
        Response response=preparedrequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().body("Message",equalTo("Employee record Updated"));
        response.then().statusCode(200);

    }
    public void dgetUpdatedEmployee() {
        // preparaing the request to get an employee
        RequestSpecification preparedrequest = given().header("Content-Type", "application/json")
                .header("Authorization", token)
                .queryParam("employee_id", employe_id);
        // now above request is prepared do not perform action on this request, in get provide endpoint from swagger.
        // this request will give response , where we will save response -- preparedquest.when().get("/getOneEmployee.php");
        Response response = preparedrequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        String firstname=response.jsonPath().getString("employee.emp_firstname");
        Assert.assertTrue(firstname.contentEquals("kangro1"));
        System.out.println(firstname);
    }
}
