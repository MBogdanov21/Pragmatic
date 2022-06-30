package login.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.BrowserActions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTestPositive {
    @BeforeMethod
    public void setUp() {
        BrowserActions.open("chrome");
    }

    @Test
    void ShouldRegisterSuccessfully() {
        RegisterPage.goTo();
        RegisterPage.fillRegisterForm("Mihail", "Bogdanov", "mbogdanov211@gmail.com", "0899476103", "123456789!", "123456789!");

//        assertTrue(LoginPage.getRadioButton().isEnabled());
//        assertTrue(LoginPage.getRadioButton().isSelected());
        assertTrue(RegisterPage.gePrivacyPolicyButton().isDisplayed());
        assertTrue(RegisterPage.gePrivacyPolicyButton().isSelected());

        RegisterPage.confirmRegistration();

        assertEquals(BrowserActions.driver.findElement(RegisterPage.SUCCESS_PAGE).getText(), "Your Account Has Been Created!");
    }

    @AfterMethod
    public void after() {
        BrowserActions.quit();
    }
}
