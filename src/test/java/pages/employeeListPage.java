package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class employeeListPage extends commonMethods {

    @FindBy(xpath="//input[@id='empsearch_id']")
    public WebElement idonListpage;


    @FindBy(xpath="//input[@id='searchBtn']")
    public WebElement searchbutton;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement nameEmployelistpage;
public employeeListPage (){
    PageFactory.initElements(driver, this);
}



}
