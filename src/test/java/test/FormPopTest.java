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
    public void shouldFIllFormWithSuccess() {
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(testEnvironment.returnValueAsString("firstName"))
                .setLastName(testEnvironment.returnValueAsString("lastName"))
                .setEmail(testEnvironment.returnValueAsString("email"))
                .selectRandomSex()
                .setAge(testEnvironment.returnValueAsString("age"))
                .selectRandomExperience()
                .setProfession()
                .setRandomContinent()
                .setCommands(driver)
                .sendFile(testEnvironment.returnValueAsString("filepath"))
                .fillAdditionalInfo(testEnvironment.returnValueAsString("additional"))
                .signIn();
        log.info("Data sent. Checking response message.");
        assertThat(formPage.getActualMessage(), equalTo(testEnvironment.returnValueAsString("message")));
    }
}