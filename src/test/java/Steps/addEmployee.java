package Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.commonMethods;

import static utils.commonMethods.driver;

public class addEmployee extends commonMethods {
    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        WebElement pimclick= driver.findElement(By.id("menu_pim_viewPimModule"));
        pimclick.click();
    }
    @When("user clicks on ADD employee button")
    public void user_clicks_on_add_employee_button() {
       WebElement add=driver.findElement(By.id("menu_pim_addEmployee"));
       add.click();
    }
    @When("user add first name and last name")
    public void user_add_first_name_and_last_name() throws InterruptedException {
        Thread.sleep(3000);
       WebElement firstname=driver.findElement(By.id("firstName"));
       firstname.sendKeys("canada");
       WebElement lastname=driver.findElement(By.id("lastName"));
       lastname.sendKeys("America");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       WebElement saveclick=driver.findElement(By.id("btnSave"));
       saveclick.click();
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {

        System.out.println("employee has been added successfully");
    }
}
