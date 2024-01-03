package utils;

import Steps.pageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class commonMethods extends pageInitializer {
            public static WebDriver driver;
            public void openBrowser(){
                configReader.read(constants.CONFIGURATION_PATH);
                switch (configReader.getvalue("browser")) {
                    case "chrome":
                        //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver =new FirefoxDriver();
                       // System.out.println("browser is not available");
                        break;
                    default:
                        throw new RuntimeException("invalid brower name");
                }
                    driver.get(configReader.getvalue("url"));
                    driver.manage().window().maximize();
                    initializerpageobjects();
                }
         public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
