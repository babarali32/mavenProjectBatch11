package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.stylesheets.LinkStyle;
import utils.commonMethods;
import java.util.*;
import io.cucumber.core.api.TypeRegistry;

import java.util.List;

public class dashboardSteps extends commonMethods {


    @Then("verify all the dashboard tabs")
    public void verify_all_the_dashboard_tabs(DataTable dataTable) {
        List<String> tabsfromfeaturefile=dataTable.asList();

        WebElement webtabslocator=driver.findElement(By.xpath("//div[@class='menu']/ul/li"));

        List<WebElement> allwebtabs=new ArrayList<>();

        //below line is used to store all webelement in form of a string inside the list of actualtabs
        List<String> actualtabs=new ArrayList<>();

        for (WebElement elements:allwebtabs
        ) {
            String allwebtabsstoreed=elements.getText();
            //in below line all website tabs are stored inside a list of string name actual tabs
            actualtabs.add(allwebtabsstoreed);
        }
        System.out.println(tabsfromfeaturefile);
        System.out.println(actualtabs);
        Assert.assertTrue(tabsfromfeaturefile.equals(actualtabs));
      }

    }

