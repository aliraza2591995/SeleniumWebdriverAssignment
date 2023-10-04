package eFinancialCareersPages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WDM {
    private final ChromeOptions chromeOptions;
    private WDM() {
        this.chromeOptions = new ChromeOptions();
    }
    public static WDM getChromeDriver() {
        return new WDM();
    }
    public ChromeDriver create() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
    public WDM incognito() {
        chromeOptions.addArguments("--incognito");
        return this;
    }
    public WDM headLess() {
        chromeOptions.addArguments("--headless=new");
        return this;
    }
    public WDM windowSize(String size) {
        chromeOptions.addArguments("--window-size=" + size);
        return this;
    }
    public WDM maxWindow() {
        chromeOptions.addArguments("start-maximized");
        return this;
    }
}
