package APIsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class generateTokenSteps {
    String BaseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;
    @Given("a JWT Bearer token is generated")

    public void a_jwt_bearer_token_is_generated() {
        RequestSpecification generatetokenrequest = given().baseUri(BaseURI).
                header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"test@12345678.com\",\n" +
                        "  \"password\": \"pakistaN32\"\n" +
                        "}");
        Response response = generatetokenrequest.when().post("/generateToken.php");
        token = "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);
    }
}
