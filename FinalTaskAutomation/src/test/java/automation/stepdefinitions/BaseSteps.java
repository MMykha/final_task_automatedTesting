package automation.stepdefinitions;

import automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {
    protected WebDriver driver;
    protected LoginPage loginPage;

    public BaseSteps(){
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
    }

}
