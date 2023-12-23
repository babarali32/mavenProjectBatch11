package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.commonMethods;
import utils.configReader;

public class LoginSteps extends commonMethods {
    @Given("user navigated to hrms website")
    public void user_navigated_to_hrms_website() {  // i am login
        openBrowser();
    }
    @When("user enters password and username")
    public void user_enters_password_and_username() { //i am here
       WebElement username= driver.findElement(By.id("txtUsername"));
       username.sendKeys(configReader.getvalue("username"));
       WebElement pas=driver.findElement(By.xpath("//input[@id='txtPassword']"));
       pas.sendKeys(configReader.getvalue("password"));
    }
    @When("user click on login button")
    public void user_click_on_login_button() {
      WebElement login=driver.findElement(By.id("btnLogin"));
      login.click();

    }
    @Then("user logged in as admin")
    public void user_logged_in_as_admin() {

        System.out.println("test is passed");
    }
    @When("Ess user enters password and username")
    public void ess_user_enters_password_and_username() {
        System.out.println("hello");
    }
    @Then("user close the browser")
    public void user_close_the_browser() {
       tearDown();
    }

}
