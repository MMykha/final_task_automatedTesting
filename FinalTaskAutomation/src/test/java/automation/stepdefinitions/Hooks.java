package automation.stepdefinitions;

import automation.core.WebDriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverInstance.getDriver(System.getProperty("browser"));
    }

    @After
    public void stopBrowser() {
        WebDriverInstance.closeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
