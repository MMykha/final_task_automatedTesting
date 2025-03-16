package automation.steps;

import automation.core.WebDriverInstance;
import automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginWithEmptyCredentialsSteps {
    private WebDriver driver = WebDriverInstance.getDriver(System.getProperty("browser"));
    private LoginPage loginPage = new LoginPage(driver);

}
