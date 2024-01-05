package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;
import utils.configReader;

public class loginpage  extends commonMethods {
    @FindBy(id="txtUsername")
    public WebElement usernameField;
    @FindBy(xpath="//input[@id='txtPassword']")
    public WebElement pas;
    @FindBy(id="btnLogin")
    public WebElement loginned;
    @FindBy(id="spanMessage")
    public WebElement errormsge;
    public loginpage () {
        PageFactory.initElements(driver,this);
    }
    public void loginpom(String user1, String pass1){
       // loginpage logpm=new loginpage();
//        usernameField.sendKeys(user1);
//        pas.sendKeys(pass1);
        sendText(usernameField, configReader.getvalue("username"));
        sendText(pas,configReader.getvalue("password"));
        click(loginned);
    }
}
