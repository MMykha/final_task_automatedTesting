package automation.stepdefinitions;

import automation.model.User;
import automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginWithEmptyCredentialsSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginWithEmptyCredentialsSteps.class);
    private User user;
    private final WebDriver driver = Hooks.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        log.info("Opening the login page");
        loginPage.openPage();
    }

    // UC - 1

    @When("I type credentials into Username {string} and Password {string} fields")
    public void iTypeCredentialsIntoUsernameAndPasswordFields(String username, String password) {
        log.info("Login with empty credentials");
        user = new User(username, password);
        loginPage.fillUsernameInput(user);
        loginPage.fillPasswordInput(user);
    }

    @When("I clear the inputs")
    public void iClearTheInputs() {
        loginPage.clearUsernameInput();
        loginPage.clearPasswordInput();
    }

    @When("I hit the Login button")
    public void iHitTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the error message: {string}")
    public void iShouldSeeTheErrorMessage(String expectedMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        log.info("Verifying error message: Expected {}, Actual {}", expectedMessage, actualErrorMessage);
        Assertions.assertThat(actualErrorMessage).isNotNull().isEqualTo(expectedMessage);
    }

    // UC - 2

    @When("I type any credentials in username {string}")
    public void iTypeAnyCredentialsInUsername(String username) {
        log.info("Login with username {} and without password", username);
        user = new User(username, "");
        user.setUsername(username);
        loginPage.fillUsernameInput(user);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        user.setPassword(password);
        loginPage.fillPasswordInput(user);
    }

    @When("I clear the Password input")
    public void iClearThePasswordInput() {
        loginPage.clearPasswordInput();
    }

    // UC - 3

    @When("I type Accepted username {string} into Username field")
    public void iTypeAcceptedUsername(String username) {
        log.info("Login with accepted credentials");
        user = new User(username, "");
        user.setUsername(username);
        loginPage.fillUsernameInput(user);
    }

    @Then("The title should be {string} in the dashboard")
    public void theTitleShouldBeInTheDashboard(String title) {
        String actualTitle = driver.getTitle();
        log.info("Verifying the title: Expected {}, Actual {}", title, actualTitle);
        Assertions.assertThat(actualTitle).isEqualTo(title);
    }

}
