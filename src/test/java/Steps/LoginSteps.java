package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.dashboardpage;
import pages.loginpage;
import utils.commonMethods;
import utils.configReader;

public class LoginSteps extends commonMethods {
    @Given("user navigated to hrms website")
    public void user_navigated_to_hrms_website() {  // i am login
        openBrowser();
    }
    @When("user enters password and username")
    public void user_enters_password_and_username() { //i am here
        //loginpage login=new loginpage();
       // login.usernameField.sendKeys(configReader.getvalue("username"));
        sendText(loginpage.login.usernameField, configReader.getvalue("username"));
//       WebElement username= driver.findElement(By.id("txtUsername"));
//       username.sendKeys(configReader.getvalue("username"));
        sendText(loginpage.login.pas,configReader.getvalue("password"));
       // login.pas.sendKeys(configReader.getvalue("password"));
//       WebElement pas=driver.findElement(By.xpath("//input[@id='txtPassword']"));
//       pas.sendKeys(configReader.getvalue("password"));
    }
    @When("user click on login button")
    public void user_click_on_login_button() {
        loginpage login=new loginpage();
      //WebElement login=driver.findElement(By.id("btnLogin"));
     // login.loginned.click();
      click(login.loginned);
    }
    @Then("user logged in as admin")
    public void user_logged_in_as_admin() {
        System.out.println("successfully logged in");
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
            loginpage login=new loginpage();
           // WebElement username1= driver.findElement(By.id("txtUsername"));
            //login.usernameField.sendKeys(username);
            sendText(login.usernameField,username);
           // WebElement pas1=driver.findElement(By.xpath("//input[@id='txtPassword']"));
           // login.pas.sendKeys(password);
            sendText(login.pas,password);
           // WebElement login=driver.findElement(By.id("btnLogin"));
             // login.loginned.click();
              click(loginpage.login.loginned);
           // WebElement actualdisplay=driver.findElement(By.id("spanMessage"));
            String actualerorstore=login.errormsge.getText();
            Assert.assertEquals("values do not match",errormsge,actualerorstore);
        }

    @When("user enter es different {string} and {string}")
    public void userEnterEsDifferentAnd(String username, String password) {
         loginpage loginPag=new loginpage();
        //WebElement username1= driver.findElement(By.id("txtUsername"));
        sendText(loginPag.usernameField, username);
      //  loginPag.usernameField.sendKeys(username);
        //sendText(loginpage.usernameField,username);
      //  loginPag.usernameField.sendKeys(username);
        //WebElement pas1=driver.findElement(By.xpath("//input[@id='txtPassword']"));
       // sendText(loginpage.pas,password);
        //login.pas.sendKeys(password);
        sendText(loginPag.pas, password);
      //  loginPag.pas.sendKeys(password);
    }
    @Then("user logged in as {string}")
    public void userLoggedInAs(String admin) {
       dashboardpage dash=new dashboardpage();
       // dash.dashboard.click();
        click(dashboardpage.dash.pim);
       // WebElement dash=driver.findElement(By.xpath("//b[text()='Dashboard']"));
       // dash.click();
        //WebElement wlcome=driver.findElement(By.id("welcome"));
       // Assert.assertTrue("not displayerd",dash.welcome.isDisplayed());


    }

    @When("user logged in with valid Amin credentials")
    public void user_logged_in_with_valid_amin_credentials() {
        // this line is my invention
        loginpage page2=new loginpage();
        page2.loginpom(configReader.getvalue("username"),configReader.getvalue("password"));
    }

}


