package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.commonMethods;

public class LoginSteps extends commonMethods {
    @Given("user navigated to hrms website")
    public void user_navigated_to_hrms_website() {
        openBrowser();
    }
    @When("user enters password and username")
    public void user_enters_password_and_username() {
       WebElement username= driver.findElement(By.id("txtUsername"));
       username.sendKeys("Admin");
       WebElement pas=driver.findElement(By.xpath("//input[@id='txtPassword']"));
       pas.sendKeys("Hum@nhrm123");
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
    @Then("user close the browser")
    public void user_close_the_browser() {
       tearDown();
    }

}
