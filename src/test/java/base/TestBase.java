package base;

import configuration.model.EnvironmentModel;
import configuration.model.PropertyModel;
import configuration.model.YamlModel;
import configuration.handler.YamlReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestBase {

    protected static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger("TestBase.class");
    public static EnvironmentModel testEnvironment;
    static String loadedEnvironmentName;
    static String loadedBrowser;
    static YamlModel model;

    @BeforeAll
    static void beforeAll() {
        model = new YamlReader().loadData();
        logLoadedData();
        testEnvironment = model.getAllTestData().get(loadedEnvironmentName);
        System.out.println(testEnvironment.toString());
//        BrowserHandler browser = new BrowserHandler(testEnvironment.getAppUrl());
//        driver = browser.getDriver(model.getTestedBrowser());
    }

    private static void logLoadedData() {
        loadedEnvironmentName = model.getTestedDataSet();
        loadedBrowser = model.getTestedBrowser();
        log.info(">>>> Configuration loaded. "  + "Browser: " + loadedBrowser + " Data set: " + loadedEnvironmentName);



    }

    @AfterAll
    static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        log.info("<<<<<<<<<<<<<<Driver CLOSE<<<<<<<<<<<<<<<<");
    }
}

