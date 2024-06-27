package eFinancialCareersTests;

import eFinancialCareersPages.HomePage;
import eFinancialCareersPages.WDM;
import eFinancialCareersPages.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    protected ExtentReports extent = ExtentReport.getInstance();
    WebDriver driver;
    public HomePage homepage;

//    @BeforeTest
    public void setup(){
        System.out.println("Setting up WebDriver and HomePage...");
        driver = WDM.getChromeDriver().incognito().maxWindow().create();
        System.out.println("WebDriver initialized: " + (driver != null));
        driver.get("https://www.efinancialcareers.com/");
        homepage = new HomePage(driver);
        System.out.println("HomePage initialized: " + (homepage != null));;
    }

//    @AfterTest
    public void teardown(){
        driver.quit();
        extent.flush();
    }
}
