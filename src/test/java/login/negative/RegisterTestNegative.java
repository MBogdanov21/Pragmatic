package login.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.BrowserActions;

import static org.junit.Assert.assertEquals;

public class RegisterTestNegative {

    @BeforeMethod
    public void setUp() {
        BrowserActions.open("chrome");
    }

    @Test
    void ShouldNOTRegisterSuccessfullyWhenEmailIsWrong() {
        RegisterPage.goTo();
        RegisterPage.fillRegisterForm("Mihail", "Bogdanov", "mbogdanov211@gmail", "0899476103", "123456789!", "123456789!");
        RegisterPage.confirmRegistration();

        String errorMessageText = RegisterPage.getErrorMessage().getText();

        assertEquals("E-Mail Address does not appear to be valid!", errorMessageText);
    }

    @Test
    void ShouldNOTRegisterSuccessfullyWhenFirstNameIsTooLong() {
        RegisterPage.goTo();
        RegisterPage.fillRegisterForm("MihailMihailMihailMihailMihailMihailMihailMihailMihailMihail", "Bogdanov", "mbogdanov@211gmail.com", "0899476103", "123456789!", "123456789!");
        RegisterPage.confirmRegistration();

        String errorMessageText = RegisterPage.getErrorMessage().getText();

        assertEquals("First Name must be between 1 and 32 characters!", errorMessageText);
    }

    @Test
    void ShouldNOTRegisterSuccessfullyWhenFirstNameIsTooShort() {
        RegisterPage.goTo();
        RegisterPage.fillRegisterForm("", "Bogdanov", "mbogdanov211@gmail.com", "0899476103", "123456789!", "123456789!");
        RegisterPage.confirmRegistration();

        String errorMessageText = RegisterPage.getErrorMessage().getText();

        assertEquals("First Name must be between 1 and 32 characters!", errorMessageText);
    }

    @Test
    void ShouldNOTRegisterSuccessfullyWhenlastNameIsTooLong() {
        RegisterPage.goTo();
        RegisterPage.fillRegisterForm("Mihail", "BogdanovBogdanovBogdanovBogdanovBogdanovBogdanovBogdanovBogdanovBogdanovBogdanovBogdanovBogdanov", "mbogdanov211@gmail.com", "0899476103", "123456789!", "123456789!");
        RegisterPage.confirmRegistration();

        String errorMessageText = RegisterPage.getErrorMessage().getText();

        assertEquals("Last Name must be between 1 and 32 characters!", errorMessageText);
    }

    @Test
    void ShouldNOTRegisterSuccessfullyWhenLastNameIsTooShort() {
        RegisterPage.goTo();
        RegisterPage.fillRegisterForm("Mihail", "", "mbogdanov211@gmail.com", "0899476103", "123456789!", "123456789!");
        RegisterPage.confirmRegistration();

        String errorMessageText = RegisterPage.getErrorMessage().getText();

        assertEquals("Last Name must be between 1 and 32 characters!", errorMessageText);
    }

    @Test
    void ShouldNOTRegisterSuccessfullyWhenPasswordsDoNOTMatch() {
        RegisterPage.goTo();
        RegisterPage.fillRegisterForm("Mihail", "aDASDASD", "mbogdanov211@gmail.com", "0899476103", "123456789!", "asd!");
        RegisterPage.confirmRegistration();

        String errorMessageText = RegisterPage.getErrorMessage().getText();

        assertEquals("Password confirmation does not match password!", errorMessageText);
    }


    @AfterMethod
    public void after() {
        BrowserActions.quit();
    }
}
