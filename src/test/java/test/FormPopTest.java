package test;

import base.TestBase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormPopTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger("FormPopTest.class");

    @Test
    public void shouldFIllFormWithSuccess() {
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(System.getProperty("firstName"))
                .setLastName(System.getProperty("lastName"))
                .setEmail(System.getProperty("email"))
                .selectRandomSex()
                .setAge(Integer.parseInt(System.getProperty("age")))
                .selectRandomExperience()
                .setProfession()
                .setRandomContinent()
                .setCommands(driver)
                .sendFile()
                .fillAdditionalInfo(System.getProperty("additional"))
                .signIn();
        assertThat(formPage.getActualMessage(), equalTo(System.getProperty("message")));
    }
}