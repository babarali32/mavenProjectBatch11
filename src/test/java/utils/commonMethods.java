package utils;

import Steps.pageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
                    driver.manage().timeouts().implicitlyWait(constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
                    initializerpageobjects();
                }
                public static void sendText(WebElement element, String texttosend){
                element.clear();
                element.sendKeys(texttosend);
                }

                public static WebDriverWait getwait(){
                WebDriverWait wait=new WebDriverWait(driver,constants.EXPLICIT_WAIT);


                return wait;
                }
                public static void waitforClickability(WebElement elementinCommonmethod){
                getwait().until(ExpectedConditions.elementToBeClickable(elementinCommonmethod));

                }
                public static void click(WebElement elementinCommonmethod){
                waitforClickability(elementinCommonmethod);
                elementinCommonmethod.click();
                }
                public static JavascriptExecutor getJsExecutor(){
                JavascriptExecutor js=(JavascriptExecutor) driver;
                return js;
                }
                public static void jsClick(WebElement jselement){
                getJsExecutor().executeScript("arguments[0].click",jselement);
                }
         public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
