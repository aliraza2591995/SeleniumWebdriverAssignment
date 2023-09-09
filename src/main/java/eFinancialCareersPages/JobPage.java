package eFinancialCareersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobPage {
    private WebDriver driver;
    private By applyLink = By.xpath("(//button[@class='btn btn-small btn-primary ng-star-inserted'])[1]");
    private By uploadLink = By.xpath("//button[@class='btn btn-outline btn-medium'][1]");
    private By fileDropArea = By.xpath("//input[@id='fsp-fileUpload']");
    public JobPage(WebDriver driver){
        this.driver = driver;
    }
    public void applyForJob(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement applyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(applyLink));
        applyElement.click();
    }
    public void uploadCV(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement uploadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadLink));
        uploadElement.click();
//        unhiddenUploadElement(fileDropArea);
//        WebElement inputFile = wait.until(ExpectedConditions.visibilityOfElementLocated(fileDropArea));
//        inputFile.sendKeys("A:/Docs/EE CV/Ali's Resume.pdf");
//        inputFile.click();
    }
    public void unhiddenUploadElement(By element){
//        WebElement hiddenElement = driver.findElement(element);
//        String script = "arguments[0].style.display='block';";
//        ((JavascriptExecutor) driver).executeScript(script, hiddenElement);

        WebElement hiddenInputElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.opacity = 1;", hiddenInputElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.height = 'auto';", hiddenInputElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.width = 'auto';", hiddenInputElement);
    }
}