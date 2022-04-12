package base;

import configuration.model.YamlModel;
import configuration.handler.YamlReader;
import configuration.handler.BrowserHandler;
import configuration.model.TestDataModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestBase {

    protected static WebDriver driver;
    private static Logger log = LoggerFactory.getLogger("TestBase.class");
    public static TestDataModel testEnvironment;


    @BeforeAll
    static void beforeAll() {

        YamlReader yr = new YamlReader();
        YamlModel model = yr.reader();
        log.info(">>>> Configuration loaded. "  + "Browser: " + model.getDefaultBrowser() + " Data set: " + model.getDefaultEnvironment());
        testEnvironment = model.getTestData().get(model.getDefaultEnvironment());
        BrowserHandler browser = new BrowserHandler(testEnvironment.getAppUrl());
        driver = browser.getDriver(model.getDefaultBrowser());
    }

    @AfterAll
    static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        log.info("<<<<<<<<<<<<<<Driver CLOSE<<<<<<<<<<<<<<<<");
    }
}

