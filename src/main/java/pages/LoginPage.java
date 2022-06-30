package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserActions;

public class LoginPage {

    private static final String HOME_PAGE_URL = "http://shop.pragmatic.bg/";
    private static final By ACCOUNT_BUTTON = By.xpath("//span[@class='caret']");

    private static final By LOGIN_BUTTON = By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]//li[2]//a");
    private static final By EMAIL_INPUT = By.xpath("//input[@id='input-email']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='input-password']");
    private static final By SUBMIT_BUTTON = By.xpath("//input[@type='submit']");

    public static final By SUCCESS_PAGE = By.xpath("//div[@id='content']//h2");
    public static final By LOGIN_CONTENT_ACCOUNT_TITLE = By.xpath("//div[@id='content']//h2[1]");
    public static final By LOGIN_CONTENT_ORDERS_TITLE = By.xpath("//div[@id='content']//h2[2]");
    public static final By LOGIN_CONTENT_AFFILIATE_TITLE = By.xpath("//div[@id='content']//h2[3]");
    public static final By LOGIN_CONTENT_NEWSLETTER_TITLE = By.xpath("//div[@id='content']//h2[4]");


    public LoginPage() {
    }

    public static void goTo() { BrowserActions.driver.get(HOME_PAGE_URL); }

    public static void fillLoginForm(String email, String password) {
        BrowserActions.driver.findElement(ACCOUNT_BUTTON).click();
        BrowserActions.driver.findElement(LOGIN_BUTTON).click();

        BrowserActions.driver.findElement(EMAIL_INPUT).sendKeys(email);
        BrowserActions.driver.findElement(PASSWORD_INPUT).sendKeys(password);

    }

    public static void login() {
        BrowserActions.driver.findElement(SUBMIT_BUTTON).click();
    }

}
