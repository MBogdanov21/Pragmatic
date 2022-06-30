package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;


/**
 * This class represents the basic browser actions which will be used within the project!
 */
public class BrowserActions {

    public static WebDriver driver;

    /**
     * Method which opens a browser by passed browserType
     * <p>
     * Valid options: chrome, firefox, opera and edge
     * </p>
     *
     * @param browserType the browser type which will be opened
     */
    public static void open(String browserType) {
        switch (browserType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            default:
                throw new RuntimeException("The browser type that you have entered " + browserType + " is incorrect!!!!");
        }
    }

    /**
     * Method that closes all of the open browser windows!
     */
    public static void quit() {
        BrowserActions.driver.quit();
    }
}
