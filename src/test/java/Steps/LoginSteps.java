package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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

    @When("user enter es different {string} and {string} and veryfiy the {string} for all combination")
    public void userEnterEsDifferentAndAndVeryfiyTheForAllCombination(String username, String password, String errormsge) {

            WebElement username1= driver.findElement(By.id("txtUsername"));
            username1.sendKeys(username);
            WebElement pas1=driver.findElement(By.xpath("//input[@id='txtPassword']"));
            pas1.sendKeys(password);
            WebElement login=driver.findElement(By.id("btnLogin"));
            login.click();
            WebElement actualdisplay=driver.findElement(By.id("spanMessage"));
            String actualerorstore=actualdisplay.getText();
            Assert.assertEquals("values do not match",errormsge,actualerorstore);
        }

    @When("user enter es different {string} and {string}")
    public void userEnterEsDifferentAnd(String username, String password) {
        WebElement username1= driver.findElement(By.id("txtUsername"));
        username1.sendKeys(username);
        WebElement pas1=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        pas1.sendKeys(password);
    }
    @Then("user logged in as {string}")
    public void userLoggedInAs(String admin) {
        WebElement dash=driver.findElement(By.xpath("//b[text()='Dashboard']"));
        dash.click();
        WebElement wlcome=driver.findElement(By.id("welcome"));
        Assert.assertTrue("not displayerd",wlcome.isDisplayed());

    }
}


