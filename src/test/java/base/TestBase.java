package base;

import configuration.handler.Browser;
import configuration.handler.BrowserHandler;
import configuration.handler.YamlReader;
import configuration.model.EnvironmentModel;
import configuration.model.YamlModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Locale;

public class TestBase {

    private static final Logger log = LoggerFactory.getLogger("TestBase.class");
    protected static EnvironmentModel testEnvironment;
    private static String loadedEnvironmentName;
    private static Browser loadedBrowser;
    protected static YamlModel model;
    protected WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        initializeTestEnvironment();
        logBasicLoadInformation();
        logDetailedLoadInformation();
    }

    private static void initializeTestEnvironment() {
        model = new YamlReader().loadData();
        loadedBrowser = model.getTestedBrowser();
        loadedEnvironmentName = model.getTestedDataSet();
        testEnvironment = new EnvironmentModel(model.getSpecificTestData(loadedEnvironmentName));
    }

    private static void logDetailedLoadInformation() {
        log.info("Tests will proceed using following data:");
        testEnvironment.getTestPropertiesMap().forEach((k, v) -> log.info("--> " + k + ": " + v));
    }

    private static void logBasicLoadInformation() {
        log.info(">>>> Parsed " + model.getAllTestData().size() + " sets of environment settings");
        log.info(">>>> Configuration loaded successfully. " + "Performing test on browser: " + loadedBrowser.name().toUpperCase(Locale.ROOT) + " using environment: " + loadedEnvironmentName.toUpperCase(Locale.ROOT));
        log.info(">>>> Environment " + loadedEnvironmentName.toUpperCase(Locale.ROOT) + " contains " + testEnvironment.getTestPropertiesMap().size() + " properties");
    }

    @BeforeEach
    void setUp() {
        BrowserHandler browser = new BrowserHandler(testEnvironment.returnValueAsString("appUrl"));
        driver = browser.getDriver(model.getTestedBrowser());
        browser.setZoom(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        log.info(">>>>>  Driver closed successfully.");
    }

    protected String getFromEnv(String key){
        return testEnvironment.returnValueAsString(key);
    }

}

