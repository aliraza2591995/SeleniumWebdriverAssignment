package eFinancialCareersTests;

import eFinancialCareersPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;
    public HomePage homepage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.efinancialcareers.com/");
        homepage = new HomePage(driver);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
