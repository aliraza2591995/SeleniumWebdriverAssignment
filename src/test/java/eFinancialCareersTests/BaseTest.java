package eFinancialCareersTests;

import eFinancialCareersPages.HomePage;
import eFinancialCareersPages.WDM;
import eFinancialCareersPages.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    protected ExtentReports extent = ExtentReport.getInstance();
    WebDriver driver;
    public HomePage homepage;

    @BeforeSuite
    public void setup(){
        driver = WDM.getChromeDriver().incognito().maxWindow().create();
        driver.get("https://www.efinancialcareers.com/");
        homepage = new HomePage(driver);
    }

    @AfterSuite
    public void teardown(){
        driver.quit();
        extent.flush();
    }
}
