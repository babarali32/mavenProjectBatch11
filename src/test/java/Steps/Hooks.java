package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.commonMethods;

public class Hooks extends commonMethods {
    @Before
    public void start(){
        openBrowser();
    }
    @After
        public void close(){
        tearDown();
        }
}
