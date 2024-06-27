package eFinancialCareersTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import eFinancialCareersPages.ExtentReport;
import eFinancialCareersPages.HomePage;
import eFinancialCareersPages.WDM;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class SignInTest {
    protected ExtentReports extent = ExtentReport.getInstance();
    WebDriver driver;
    public HomePage homepage;

    @BeforeTest
    public void setup(){
        System.out.println("Setting up WebDriver and HomePage...");
        driver = WDM.getChromeDriver().incognito().maxWindow().headLess().create();
        System.out.println("WebDriver initialized: " + (driver != null));
        driver.get("https://www.efinancialcareers.com/");
        homepage = new HomePage(driver);
        System.out.println("HomePage initialized: " + (homepage != null));;
    }

    @AfterTest
    public void teardown(){
        driver.quit();
        extent.flush();
    }
    @Test
    public void testSignIn() {

        System.out.println("Starting testSignIn...");
        if (homepage == null) {
            System.out.println("Homepage is null in testSignIn!");
            return;
        }
        homepage.clickSignIn();
        assertEquals(homepage.getOverlayText(), "Welcome to your next opportunity", "Didn't click signIn button correctly");

        homepage.enterEmail("aliomessi.19@gmail.com");
        homepage.enterPassword("Aliraza.10");

        homepage.clickProfileButton();
        assertEquals(homepage.checkLoginStatus(), "Ali Raza", "Login failed");
    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
//        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentTest test = extent.createTest("eFinancialCareers page SignIn test.");
        test.log(Status.INFO, "Test Started");

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed");
            test.log(Status.FAIL, "Error Message: " + result.getThrowable().getMessage());
            if (driver instanceof TakesScreenshot) {
                String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
                try {
                    test.addScreenCaptureFromPath(screenshotPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        } else {
            test.log(Status.SKIP, "Test Skipped");
        }
    }

    private String captureScreenshot(String methodName) {
        String screenshotPath = "A:\\Em\\SeleniumWebdriverAssignment\\src\\test\\Reports\\" + methodName + ".png";
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}