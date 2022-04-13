package base;

import configuration.handler.BrowserHandler;
import configuration.handler.YamlReader;
import configuration.model.EnvironmentModel;
import configuration.model.YamlModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Locale;


public class TestBase {

    private static final Logger log = LoggerFactory.getLogger("TestBase.class");
    protected static EnvironmentModel testEnvironment;
    private static String loadedEnvironmentName;
    private static String loadedBrowser;
    private static YamlModel model;
    public WebDriver driver;


    @BeforeAll
    static void beforeAll() {
        initializeTestEnvironment();
        logBasicLoadInformation();
        logDetailedLoadInformation();

    }

    private static void initializeTestEnvironment() {
        model = new YamlReader().loadData();
        loadedEnvironmentName = model.getTestedDataSet();
        loadedBrowser = model.getTestedBrowser();
        testEnvironment = new EnvironmentModel(model.getSpecificTestData(loadedEnvironmentName));

    }

    private static void logDetailedLoadInformation() {
        log.info("Tests will proceed using following data:");
        testEnvironment.getMapOfProperties().forEach((k, v) -> log.info("--> " + k + ": " + v));
    }

    private static void logBasicLoadInformation() {
        log.info(">>>> Parsed " + model.getAllTestData().size() + " sets of environment settings");
        log.info(">>>> Configuration loaded successfully. " + "Performing test on browser: " + loadedBrowser.toUpperCase(Locale.ROOT) + " using environment: " + loadedEnvironmentName.toUpperCase(Locale.ROOT));
        log.info(">>>> Environment " + loadedEnvironmentName.toUpperCase(Locale.ROOT) + " contains " + testEnvironment.getMapOfProperties().size() + " properties");
    }

    @BeforeEach
    void setUp() {
        BrowserHandler browser = new BrowserHandler(testEnvironment.returnStringValue("appUrl"));
        driver = browser.getDriver(model.getTestedBrowser());
    }

    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        log.info(">>>>>  Driver closed successfully.");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static EnvironmentModel getTestEnvironment() {
        return testEnvironment;
    }
}

