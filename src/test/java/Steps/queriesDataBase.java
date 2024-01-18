package Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.commonMethods;
import utils.dButils;
import utils.globalVariables;

import static java.util.logging.Logger.global;

public class queriesDataBase extends commonMethods {

    @When("query the information from backEnd")
    public void query_the_information_from_back_end() {
        String query="SELECT * FROM person where id=';"+ globalVariables.id+"'";

        globalVariables.tabledata= dButils.getTableData(query);


    }
    @Then("verify the results from backEnd and frontEnd")
    public void verify_the_results_from_back_end_and_front_end() {
         String firstnamefromdB=globalVariables.tabledata.get(0).get("firstname");
        System.out.println("firstname from the data base "+firstnamefromdB);
        System.out.println("first name from website"+globalVariables.firstName);

    }
}
