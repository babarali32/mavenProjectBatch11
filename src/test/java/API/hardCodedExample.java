package API;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static utils.commonMethods.driver;

public class hardCodedExample {

    // this @test is annotation in junit to Run any method ,
    @Test
    public  void sampletest(){
        // storing the base uri
        String BaseURI=RestAssured.baseURI= "http://hrm.syntaxtechs.net/syntaxapi/api";
        // preparaing the request to get an employee
        RequestSpecification preparedrequest=given().header("Content-Type","application/json")
                .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDY0MTMxNzcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwNjQ1NjM3NywidXNlcklkIjoiNjM5NSJ9.GniHlUq8Jlh9VQRjPEzPrJ8OI-5U69t9BqzSFtJQPzA")
                .queryParam("employee_id","103577A");
        // now above request is prepared do not perform action on this request, in get provide endpoint from swagger.
        // this request will give response , where we will save response -- preparedquest.when().get("/getOneEmployee.php");
                 Response response =preparedrequest.when().get("/getOneEmployee.php");
                 // response in terms of string please print
        //from convert any thing from java , we use to String method
        // this is converting from json to string thats why this is using as string
        System.out.println(response.asString());
        
    }
}
