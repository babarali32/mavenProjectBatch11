package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.employeeListPage;
import utils.commonMethods;

import static utils.commonMethods.driver;

public class employeeSearchByID extends commonMethods {


    @When("user navigate to employe list")
    public void user_navigate_to_employe_list() {
        System.out.println();
    }
    @When("user enters valid employe id")
    public void user_enters_valid_employe_id() {
        //employeeListPage listemp=new employeeListPage();
        employlist.idonListpage.sendKeys("578463453");
//
//        WebElement id=driver.findElement(By.id("empsearch_id"));
//        id.sendKeys("578463453");
    }
    @When("click on search button")
    public void click_on_search_button() {
      //  employeeListPage listemp=new employeeListPage();
        employlist.searchbutton.click();
//
//        WebElement searchbutton=driver.findElement(By.id("searchBtn"));
//        searchbutton.click();
    }
    @Then("user see the employe information")
    public void user_see_the_employe_information() {
        System.out.println("information is displayed");
    }

    @When("user enters valid employe name")
    public void user_enters_valid_employe_name() {
        //employeeListPage listemp=new employeeListPage();
        employlist.nameEmployelistpage.sendKeys("Azia");
//
//       WebElement name=driver.findElement(By.id("empsearch_employee_name_empName"));
//       name.sendKeys("Azia");
    }

}
