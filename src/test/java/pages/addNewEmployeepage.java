package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

import static utils.commonMethods.driver;

public class addNewEmployeepage extends commonMethods {

    @FindBy(id="firstName")
    public WebElement firstname;

    @FindBy(id="middleName")
    public WebElement middlename;

    @FindBy(id="lastName")
    public WebElement lastname;
    @FindBy(xpath="//input[@id='employeeId']")
    public WebElement employeeid;
    @FindBy(id="chkLogin")
    public WebElement checkbox;

    @FindBy(xpath="//input[@id='photofile']")
    public WebElement photo;

    @FindBy(xpath="//input[@id='user_name']")
    public WebElement username;
    @FindBy(xpath="//input[@id='user_password']")
    public WebElement password;
    @FindBy(xpath="//input[@id='re_password']")
    public WebElement repassword;

    @FindBy(id="btnSave")
    public WebElement savebutton;

   public addNewEmployeepage (){
       PageFactory.initElements(driver,this);
    }

}
