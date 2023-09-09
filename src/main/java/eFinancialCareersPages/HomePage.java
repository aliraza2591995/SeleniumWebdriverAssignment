package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By signIn = By.xpath("//button[@class='btn btn-secondary btn-medium ng-star-inserted']");
    private By overLayText = By.xpath("//span[text()='Welcome to your next opportunity']");
    private By emailInput = By.xpath("//input[@name='email']");
    private By continueButton = By.xpath("//button[text() = 'Continue']");
    private By passwordInput = By.xpath("//input[@name='password']");
    private By submitCredentialsButton = By.xpath("//button[text()='Submit']");
    private By jobSearchField = By.xpath("//input[@placeholder='Job title, keyword or company']");
    private By locationField = By.xpath("//input[@placeholder='Location']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickSignIn(){
        driver.findElement(signIn).click();
    }
    public String getOverlayText(){
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement overlayElement = wait.until(ExpectedConditions.visibilityOfElementLocated(overLayText));
        return overlayElement.getText();
    }
    public void enterEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(continueButton).click();
    }
    public void enterPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordField.sendKeys(password);
        driver.findElement(submitCredentialsButton).click();
    }
    public JobSearchPage jobSearch(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement jobSearchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jobSearchField));
        jobSearchElement.sendKeys("QA Engineer");
        driver.findElement(locationField).sendKeys("America" + Keys.ENTER);
        return new JobSearchPage(driver);
    }
}