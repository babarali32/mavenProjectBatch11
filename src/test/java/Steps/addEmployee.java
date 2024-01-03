package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.addNewEmployeepage;
import pages.dashboardpage;
import utils.commonMethods;
import utils.constants;
import utils.excelReading;
import pages.employeeListPage;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class addEmployee extends commonMethods {
    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        dashboardpage dash=new dashboardpage();
        dash.pim.click();
//        WebElement pimclick= driver.findElement(By.id("menu_pim_viewPimModule"));
//        pimclick.click();
    }
    @When("user clicks on ADD employee button")
    public void user_clicks_on_add_employee_button() {
        //dashboardpage dash=new dashboardpage();
        dash.addEmployee.click();
//       WebElement addemployebutton=driver.findElement(By.id("menu_pim_addEmployee"));
//       addemployebutton.click();
    }
    @When("user add first name and last name")
    public void user_add_first_name_and_last_name() throws InterruptedException {
        Thread.sleep(3000);
        //addNewEmployeepage addEmployee=new addNewEmployeepage();
        addEmployee.firstname.sendKeys("canada");
//       WebElement firstname=driver.findElement(By.id("firstName"));
//       firstname.sendKeys("canada");
        addEmployee.lastname.sendKeys("london");
//       WebElement lastname=driver.findElement(By.id("lastName"));
//       lastname.sendKeys("America");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       // addNewEmployeepage addEmployee=new addNewEmployeepage();
        addEmployee.savebutton.click();
//       WebElement saveclick=driver.findElement(By.id("btnSave"));
//       saveclick.click();
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {

        System.out.println("employee has been added successfully");
    }

    @When("user add {string} and middle {string} and {string} last name")
    public void user_add_and_middle_and_last_name(String firstName, String middleName, String lastName) {
        //addNewEmployeepage addEmployee=new addNewEmployeepage();
        addEmployee.firstname.sendKeys(firstName);

//        WebElement firstname1=driver.findElement(By.id("firstName"));
//        firstname1.sendKeys(firstName);
        addEmployee.middlename.sendKeys(middleName);
//        WebElement midlename2=driver.findElement(By.id("middleName"));
//        midlename2.sendKeys(middleName);
        addEmployee.lastname.sendKeys(lastName);
//        WebElement lastname3=driver.findElement(By.id("lastName"));
//        lastname3.sendKeys(lastName);

    }
        //below, first parameter is considered as first name and middle parameter is considere as middle name
    // and last parameter string lastname i considered as last name, because in add feature file scenario
    // we have add the name in double quots.
    @When("user enters direct data {string} and middle {string} and {string} last name")
    public void user_enters_direct_data_and_middle_and_last_name(String firstName, String middleName, String lastName) {
      //addNewEmployeepage addEmployee=new addNewEmployeepage();
      addEmployee.firstname.sendKeys(firstName);
//        WebElement firstname1=driver.findElement(By.id("firstName"));
//        firstname1.sendKeys(firstName);// this will take first name from feature file as rana
       addEmployee.middlename.sendKeys(middleName);
//        WebElement midlename2=driver.findElement(By.id("middleName"));
//        midlename2.sendKeys(middleName);// this will take 2nd value as middle name babar from featrue file
       addEmployee.lastname.sendKeys(lastName);
//        WebElement lastname3=driver.findElement(By.id("lastName"));
//        lastname3.sendKeys(lastName);
    }

    @When("user add multiple employees and verigy they added")
    public void user_add_multiple_employees_and_verigy_they_added( DataTable dataTable) throws InterruptedException {
       // addNewEmployeepage addEmployee=new addNewEmployeepage();

        List<Map<String,String>> employeenames=dataTable.asMaps();
        int sizeoftable=employeenames.size();
        System.out.println(sizeoftable);
        for (Map<String,String> names:employeenames
             ) {
            String firstkey=names.get("firstName");
            String secondkey=names.get("middleName");
            String thirdkey=names.get("lastName");

            addEmployee.firstname.sendKeys("firstName");
//
//            WebElement firstname1=driver.findElement(By.id("firstName"));
//            firstname1.sendKeys(firstkey);// this will take first name from feature file as rana
            addEmployee.middlename.sendKeys("middleName");
//
//            WebElement midlename2=driver.findElement(By.id("middleName"));
//            midlename2.sendKeys(secondkey);// this will take 2nd value as middle name babar from featrue file
          addEmployee.lastname.sendKeys("lastName");
//
//            WebElement lastname3=driver.findElement(By.id("lastName"));
//            lastname3.sendKeys(thirdkey);
//            addEmployee.savebutton.click();
//            WebElement saveclick=driver.findElement(By.id("btnSave"));
//            saveclick.click();
//            WebElement personaldetaildisplay=driver.findElement(By.xpath("//h1[text()='Personal Details']"));
//            Assert.assertTrue("personal details not displayed logo",personaldetaildisplay.isDisplayed());
            Thread.sleep(5000);
           // dashboardpage dash=new dashboardpage();
            dash.employeeListbutton.click();
//
//
//            WebElement addemployebutton=driver.findElement(By.id("menu_pim_addEmployee"));
//            addemployebutton.click();
            Thread.sleep(5000);
        }
    }
    @When("user adds multiply employees from the {string} sheet and verify the added employees")
    public void user_adds_multiply_employees_from_the_sheet_and_verify_the_added_employees(String sheetName) throws InterruptedException {
       // dashboardpage dash = new dashboardpage();
       // addNewEmployeepage addEmployee = new addNewEmployeepage();
        List<Map<String, String>> newEmploye = excelReading.exceldataintolist(constants.CONFIGURATION_FILEPATH, sheetName);
        Iterator<Map<String, String>> itar = newEmploye.iterator();
        while (itar.hasNext()) {
            Map<String, String> mapiterator = itar.next();
            addEmployee.firstname.sendKeys(mapiterator.get("firstName"));
//                WebElement firstname1=driver.findElement(By.id("firstName"));
//                firstname1.sendKeys(mapiterator.get("firstName"));
            addEmployee.middlename.sendKeys(mapiterator.get("middleName"));
//                WebElement midlename2=driver.findElement(By.id("middleName"));
//                midlename2.sendKeys(mapiterator.get("middleName"));
            addEmployee.lastname.sendKeys(mapiterator.get("lastName"));
//                WebElement lastname3=driver.findElement(By.id("lastName"));
//                lastname3.sendKeys(mapiterator.get("lastName"));
            String needvalue = addEmployee.employeeid.getAttribute("value");
//                WebElement attribute=driver.findElement(By.xpath("//input[@id='employeeId']"));
//                String needvalue=attribute.getAttribute("value");
//                WebElement photo=driver.findElement(By.xpath("//input[@id='photofile']"));
//                photo.sendKeys(mapiterator.get("photo"));
            WebElement Checkbox = addEmployee.checkbox;
//                WebElement checkbox=driver.findElement(By.id("chkLogin"));
            if (!Checkbox.isSelected()) {
                Checkbox.click();
            }
            addEmployee.username.sendKeys(mapiterator.get("userName"));
//                WebElement username2=driver.findElement(By.xpath("//input[@id='user_name']"));
//                username2.sendKeys(mapiterator.get("userName"));
            addEmployee.password.sendKeys(mapiterator.get("password"));
            addEmployee.repassword.sendKeys(mapiterator.get("password"));
//                WebElement paswrd=driver.findElement(By.xpath("//input[@id='user_password']"));
//                WebElement confirmpass=driver.findElement(By.xpath("//input[@id='re_password']"));
//                paswrd.sendKeys(mapiterator.get("password"));
//                confirmpass.sendKeys(mapiterator.get("password"));
            addEmployee.savebutton.click();
//                WebElement saveclick=driver.findElement(By.id("btnSave"));
//                saveclick.click();
            dash.employeeListbutton.click();
//                WebElement employlist=driver.findElement(By.id("menu_pim_viewEmployeeList"));
//                employlist.click();
          //  employeeListPage listpage = new employeeListPage();
            employlist.idonListpage.sendKeys(needvalue);
//                WebElement id=driver.findElement(By.xpath("//input[@id='empsearch_id']"));
//                id.sendKeys(needvalue);
            employlist.searchbutton.click();
//
//                WebElement search=driver.findElement(By.xpath("//input[@id='searchBtn']"));
//                search.click();

            List<WebElement> allrow = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i = 0; i < allrow.size(); i++) {
                System.out.println("i am inside the loop");
                String rowtext = allrow.get(i).getText();
                System.out.println(rowtext);

//                    String excelfileemployedata=needvalue+" "+mapiterator.get("firstName")+" "+mapiterator.get("middleName")+" "+mapiterator.get("lastName");
//                    System.out.println(excelfileemployedata);
//                    Assert.assertEquals(rowtext,excelfileemployedata);

            }
            Thread.sleep(4000);
            dash.addEmployee.click();
//                WebElement addemployebutton=driver.findElement(By.id("menu_pim_addEmployee"));
//                addemployebutton.click();
            Thread.sleep(4000);
        }
    }
}

