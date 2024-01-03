package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

import java.util.List;

public class dashboardpage  extends commonMethods {

    @FindBy(xpath = "//b[text()='Dashboard']")
    public WebElement dashboard;

    @FindBy(id="welcome")
    public WebElement welcome;

    @FindBy(xpath = "//div[@class='menu']/ul/li")
    public List<WebElement> webtabslocator;

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pim;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployee;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListbutton;



    public dashboardpage(){
        PageFactory.initElements(driver,this);
    }
}
