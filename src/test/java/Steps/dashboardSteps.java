package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.dashboardpage;
import utils.commonMethods;
import java.util.*;

import java.util.List;

public class dashboardSteps extends commonMethods {


    @Then("verify all the dashboard tabs")
    public void verify_all_the_dashboard_tabs(DataTable dataTable) {
       // dashboardpage dashboard=new dashboardpage();

        List<String> tabsfromfeaturefile=dataTable.asList();

       // List<WebElement> webtabslocator=driver.findElements(By.xpath("//div[@class='menu']/ul/li"));

        List<String> actualtabs=new ArrayList<>();

        //below line is used to store all webelement in form of a string inside the list of actualtabs
//        List<String> actualtabs=new ArrayList<>();

        for (WebElement elements:dash.webtabslocator
        ) {
                    String tabs=elements.getText();
            //in below line all website tabs are stored inside a list of string name actual tabs
            actualtabs.add(tabs);
        }
        System.out.println(tabsfromfeaturefile);
        System.out.println(actualtabs);
        Assert.assertTrue(tabsfromfeaturefile.equals(actualtabs));
      }

    }

