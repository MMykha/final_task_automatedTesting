package automation.stepdefinitions;

import automation.model.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginWithUsernameSteps extends BaseSteps {
    private User user;
    private static final Logger log = LoggerFactory.getLogger(LoginWithUsernameSteps.class);

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        log.info("Opening the login page");
        loginPage.openPage();
    }

    @When("I type any credentials in username {string}")
    public void iTypeAnyCredentialsInUsername(String username) {
        log.info("Login with username {} and without password", username);
        user = new User(username, "");
        loginPage.fillUsernameInput(user);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        user.setPassword(password);
        loginPage.fillPasswordInput(user);
    }

    @And("I clear the Password input")
    public void iClearThePasswordInput() {
        loginPage.clearPasswordInput();
    }

    @And("I hit the Login button")
    public void iHitTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the error message: {string}")
    public void iShouldSeeTheErrorMessage(String expectedMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        log.info("Verifying error message: Expected {}, Actual {}", expectedMessage, actualErrorMessage);
        Assertions.assertThat(actualErrorMessage).isNotNull().isEqualTo(expectedMessage);
    }
}
