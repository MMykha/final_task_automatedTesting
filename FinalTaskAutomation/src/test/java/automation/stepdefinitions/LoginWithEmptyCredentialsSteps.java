package automation.stepdefinitions;

import automation.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginWithEmptyCredentialsSteps extends BaseSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginWithEmptyCredentialsSteps.class);

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        log.info("Opening the login page");
        loginPage.openPage();
    }

    @When("I type credentials into Username {string} and Password {string} fields")
    public void iTypeCredentialsIntoUsernameAndPasswordFields(String username, String password) {
        log.info("Login with empty credentials");
        User user = new User(username, password);
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

}
