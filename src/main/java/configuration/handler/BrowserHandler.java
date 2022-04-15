package configuration.handler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserHandler {

    private static final Logger log = LoggerFactory.getLogger("BrowserHandler.class");
    private final String appUrl;

    public BrowserHandler(String appUrl) {
        this.appUrl = appUrl;
    }

    public WebDriver getDriver(Browser browser) {
        WebDriver driver;
        switch (browser) {
            case CHROME:
                driver = getChrome();
                break;
            case FIREFOX:
                driver = getFirefox();
                break;
            case EDGE:
                driver = getEdge();
                break;
            default:
                driver = getIe();
                break;
        }
        log.info(">>>> Driver started. Browser: " + browser.name());
        driver.get(appUrl);
        return driver;
    }

    private WebDriver getIe() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private WebDriver getEdge() {
        EdgeOptions optionsEdge = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        optionsEdge.addArguments("start-maximized");
        return new EdgeDriver(optionsEdge);
    }

    private WebDriver getFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver getChrome() {
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        return new ChromeDriver(optionsChrome);
    }

    public void setZoom(WebDriver driver) {
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.body.style.zoom='100%'");
    }
}
