package Runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/addEmployee.feature",
        glue = "Steps",// this command is used to make link wiht feature file
        dryRun = false, // this keyword checks the unimplmented steps and also print scenario in console
        monochrome = true, //this removes the extra lines from code
        tags = "@DataBase",  // this command will run only smoke scenario not any other scenario.
        //tags = "@smoke or @regression"   you can use more then two tags to run scenario.
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
)
public class DataBaseRunner {
}
