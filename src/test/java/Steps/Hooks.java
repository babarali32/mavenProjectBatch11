package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.commonMethods;

public class Hooks extends commonMethods {
    @Before
    public void start(){
        openBrowser();
    }
    @After
        public void close(Scenario scenario){
            // scenario class in cucumber holds complete about execution
        byte [] pic;
        if (scenario.isFailed()){
            pic=takescreenshot("failed/" + scenario.getName());
        } else {
            pic=takescreenshot("passed/" + scenario.getName());
        }
        scenario.attach(pic,"image/png", scenario.getName());
        tearDown();
        }
}
