package configuration.handler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserHandler {

    private static final Logger log = LoggerFactory.getLogger("BrowserHandler.class");
    private final String appUrl;

    public BrowserHandler(String appUrl) {
        this.appUrl = appUrl;
    }

    public WebDriver getDriver(String defaultBrowser) {
        WebDriver driver;
        switch (defaultBrowser) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                driver.get(appUrl);
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                driver.get(appUrl);
                break;
            default:
                InternetExplorerOptions defaultOptions = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(defaultOptions);
                driver.get(appUrl);
        }
        log.info("Driver started. Browser: " + defaultBrowser);
        return driver;
    }
}
