package eFinancialCareersTests;

import eFinancialCareersPages.HomePage;
import eFinancialCareersPages.WDM;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    private WebDriver driver;
    public HomePage homepage;

    @BeforeClass
    public void setup(){
        driver = WDM.getChromeDriver().incognito().maxWindow().headLess().create();
        driver.get("https://www.efinancialcareers.com/");
        homepage = new HomePage(driver);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
