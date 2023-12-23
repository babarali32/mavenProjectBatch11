package Runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/addEmployee.feature",
        glue = "Steps",// this command is used to make link wiht feature file
        dryRun = false, // this keyword checks the unimplmented steps
        // dry run command also print all cucumber steps in console.

        monochrome = true, //this command clear and clean the console
        tags = "@babar",  // this command will run only smoke scenario not any other scenario.
        //tags = "@smoke or @regression"   you can use more then two tags to run scenario.
        plugin = {"pretty","html:target/cucumber.html"}

)
public class regressionRunner {
}
