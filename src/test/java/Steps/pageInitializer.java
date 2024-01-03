package Steps;

import pages.addNewEmployeepage;
import pages.dashboardpage;
import pages.employeeListPage;
import pages.loginpage;

public class pageInitializer {
    public static addNewEmployeepage addEmployee;
    public static dashboardpage dash;
    public static employeeListPage employlist;
    public static loginpage login;

    public static void initializerpageobjects(){
        addEmployee=new addNewEmployeepage();
        dash =new dashboardpage();
        employlist =new employeeListPage();
        login =new loginpage();
    }

}
