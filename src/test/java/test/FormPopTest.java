package test;

import base.TestBase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class  FormPopTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger("FormPopTest.class");

    @Test
    public void shouldFIllFormWithSuccess() {
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(testEnvironment.getFirstName())
                .setLastName(testEnvironment.getLastName())
                .setEmail(testEnvironment.getEmail())
                .selectRandomSex()
                .setAge(testEnvironment.getAge())
                .selectRandomExperience()
                .setProfession()
                .setRandomContinent()
                .setCommands(driver)
                .sendFile(testEnvironment.filePath())
                .fillAdditionalInfo(testEnvironment.getAdditional())
                .signIn();
        log.info("Data sent. Checking response message.");
        assertThat(formPage.getActualMessage(), equalTo(testEnvironment.getMessage()));
    }
}