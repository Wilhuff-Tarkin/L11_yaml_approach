package test;

import base.TestBase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class  FormPopTest extends TestBase {
    private static final Logger log = LoggerFactory.getLogger("FormPopTest.class");

    @Test
    public void shouldFIllFormWithSuccess() throws InterruptedException {
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(getFromEnv("firstName"))
                .setLastName(getFromEnv("lastName"))
                .setEmail(getFromEnv("email"))
                .selectRandomSex()
                .setAge(getFromEnv("age"))
                .selectRandomExperience()
                .setProfession()
                .setRandomContinent()
                .setCommands(driver, model.getTestedBrowser())
                .sendFile(getFromEnv("filepath"))
                .fillAdditionalInfo(getFromEnv("additional"))
                .signIn();
        Thread.sleep(1000);
        log.info("Data sent. Checking response message.");
        assertThat(formPage.getActualMessage(), equalTo(getFromEnv("message")));
    }

    private String getFromEnv (String key){
        return testEnvironment.returnValueAsString(key);
    }
}