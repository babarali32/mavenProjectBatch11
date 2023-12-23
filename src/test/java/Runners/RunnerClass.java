package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "Steps",// this command is used to make link wiht feature file
        dryRun = false, // this keyword checks the unimplmented steps
        monochrome = true, //this removes the extra lines from code
        tags = "@smoke",  // this command will run only smoke scenario not any other scenario.
        plugin = {"pretty","html:target/cucumber.html"}
)


public class RunnerClass {

}
