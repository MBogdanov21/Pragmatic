package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserActions;

public class RegisterPage {

    private static final String HOME_PAGE_URL = "http://shop.pragmatic.bg/";
    private static final By ACCOUNT_BUTTON = By.xpath("//span[@class='caret']");
    private static final By REGISTER_BUTTON = By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]//li[1]//a");
    private static final By FIRSTNAME_INPUT = By.xpath("//input[@id='input-firstname']");
    private static final By LASTNAME_INPUT = By.xpath("//input[@id='input-lastname']");
    private static final By EMAIL_INPUT = By.xpath("//input[@id='input-email']");
    private static final By TELEPHONE_INPUT = By.xpath("//input[@id='input-telephone']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='input-password']");
    private static final By CONFIRM_PASSWORD_INPUT = By.xpath("//input[@id='input-confirm']");
    private static final By SUBSCRIBE_RADIO_BUTTON = By.cssSelector(".radio-inline:nth-of-type(1)");
    private static final By PRIVACY_POLICY_CHECKBOX = By.cssSelector(".pull-right [type=\"checkbox\"]");
    private static final By SUBMIT_BUTTON = By.cssSelector(".pull-right [type=\"submit\"]");

    public static final By SUCCESS_PAGE = By.xpath("//div[@id='content']//h1");

    public static final By ERROR_MESSAGE = By.cssSelector(".text-danger");

    public RegisterPage() {
    }

    public static void goTo() { BrowserActions.driver.get(HOME_PAGE_URL); }

    public static void fillRegisterForm(String firstname, String lastname, String email, String tel, String password, String confirm) {
        BrowserActions.driver.findElement(ACCOUNT_BUTTON).click();
        BrowserActions.driver.findElement(REGISTER_BUTTON).click();

        BrowserActions.driver.findElement(FIRSTNAME_INPUT).sendKeys(firstname);
        BrowserActions.driver.findElement(LASTNAME_INPUT).sendKeys(lastname);
        BrowserActions.driver.findElement(EMAIL_INPUT).sendKeys(email);
        BrowserActions.driver.findElement(TELEPHONE_INPUT).sendKeys(tel);
        BrowserActions.driver.findElement(PASSWORD_INPUT).sendKeys(password);
        BrowserActions.driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(confirm);

        BrowserActions.driver.findElement(SUBSCRIBE_RADIO_BUTTON).click();
        BrowserActions.driver.findElement(PRIVACY_POLICY_CHECKBOX).click();

    }

    public static void confirmRegistration() {
        BrowserActions.driver.findElement(SUBMIT_BUTTON).click();
    }

    public static WebElement getRadioButton() {
        return BrowserActions.driver.findElement(SUBSCRIBE_RADIO_BUTTON);
    }

    public static WebElement gePrivacyPolicyButton() {
        return BrowserActions.driver.findElement(PRIVACY_POLICY_CHECKBOX);
    }

    public static WebElement getErrorMessage() {
        return BrowserActions.driver.findElement(ERROR_MESSAGE);
    }

}
