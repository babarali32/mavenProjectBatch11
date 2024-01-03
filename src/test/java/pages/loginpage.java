package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class loginpage  extends commonMethods {

    @FindBy(id="txtUsername")
    public WebElement username;

    @FindBy(xpath="//input[@id='txtPassword']")
    public WebElement pas;

    @FindBy(id="btnLogin")
    public WebElement login;

    @FindBy(id="spanMessage")
    public WebElement errormsge;

    public loginpage () {

        PageFactory.initElements(driver,this);

    }
}
