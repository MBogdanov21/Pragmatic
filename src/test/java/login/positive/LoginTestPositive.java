package login.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utils.BrowserActions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTestPositive {
    @BeforeMethod
    public void setUp() {
        BrowserActions.open("chrome");
    }

    @Test
    void ShouldRegisterSuccessfully() {
        LoginPage.goTo();
        LoginPage.fillLoginForm( "mbogdanov21@gmail.com", "123456789!");

        LoginPage.login();

        assertEquals(BrowserActions.driver.findElement(LoginPage.LOGIN_CONTENT_ACCOUNT_TITLE).getText(), "My Account");
        assertEquals(BrowserActions.driver.findElement(LoginPage.LOGIN_CONTENT_ORDERS_TITLE).getText(), "My Orders");
        assertEquals(BrowserActions.driver.findElement(LoginPage.LOGIN_CONTENT_AFFILIATE_TITLE).getText(), "My Affiliate Account");
        assertEquals(BrowserActions.driver.findElement(LoginPage.LOGIN_CONTENT_NEWSLETTER_TITLE).getText(), "Newsletter");
    }

    @AfterMethod
    public void after() {
        BrowserActions.quit();
    }
}