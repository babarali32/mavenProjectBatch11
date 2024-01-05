package utils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class constants {
    public static final String CONFIGURATION_PATH=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    public static final String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/testData/employedata.xlsx";
    public static final int IMPLICIT_WAIT=5;
    public static final int EXPLICIT_WAIT=10;

}
