package eFinancialCareersPages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentReport {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("A:\\Em\\SeleniumWebdriverAssignment\\src\\test\\Reports\\ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}