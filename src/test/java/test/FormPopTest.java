package test;

import base.TestBase;
import configuration.model.EnvironmentModel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class  FormPopTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger("FormPopTest.class");

    @Test
    public void shouldFIllFormWithSuccess() {
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(testEnvironment.returnStringValue("firstName"))
                .setLastName(testEnvironment.returnStringValue("lastName"))
                .setEmail(testEnvironment.returnStringValue("email"))
                .selectRandomSex()
                .setAge(testEnvironment.returnStringValue("age"))
                .selectRandomExperience()
                .setProfession()
                .setRandomContinent()
                .setCommands(driver)
                .sendFile(testEnvironment.returnStringValue("filepath"))
                .fillAdditionalInfo(testEnvironment.returnStringValue("additional"))
                .signIn();
        log.info("Data sent. Checking response message.");
        assertThat(formPage.getActualMessage(), equalTo(testEnvironment.returnStringValue("message")));
    }
}