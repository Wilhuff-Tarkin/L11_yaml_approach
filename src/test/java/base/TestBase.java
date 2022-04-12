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
    private static final Logger log = LoggerFactory.getLogger("TestBase.class");
    public static TestDataModel testEnvironment;

    @BeforeAll
    static void beforeAll() {
        YamlModel model = new YamlReader().loadData();
        log.info(">>>> Configuration loaded. "  + "Browser: " + model.getTestedBrowser() + " Data set: " + model.getTestedDataSet());
        testEnvironment = model.getTestData().get(model.getTestedDataSet());
        BrowserHandler browser = new BrowserHandler(testEnvironment.getAppUrl());
        driver = browser.getDriver(model.getTestedBrowser());
    }

    @AfterAll
    static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        log.info("<<<<<<<<<<<<<<Driver CLOSE<<<<<<<<<<<<<<<<");
    }
}

