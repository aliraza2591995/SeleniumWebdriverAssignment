package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobSearchPage {
    private final WebDriver driver;
    private final By searchResultText = By.xpath("//h1[contains(text(), 'QA Engineer')]");
    private final By jobLink = By.xpath("//*[@id=\"rbVRgNtRyil1iTia\"]");
    public JobSearchPage(WebDriver driver){
        this.driver = driver;
    }
    public String getJobSearchResultText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchResultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultText));
        return searchResultElement.getText();
    }
    public JobPage clickJobLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(jobLink));
        driver.findElement(jobLink).click();
        return new JobPage(driver);
    }
}