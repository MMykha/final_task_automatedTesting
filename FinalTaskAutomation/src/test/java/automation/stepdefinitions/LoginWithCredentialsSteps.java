package automation.stepdefinitions;

import automation.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginWithCredentialsSteps extends BaseSteps {
    private User user;
    private static final Logger log = LoggerFactory.getLogger(LoginWithCredentialsSteps.class);

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        log.info("Opening the login page");
        loginPage.openPage();
    }

    @When("I type Accepted username {string} into Username field")
    public void iTypeAcceptedUsername(String username) {
        log.info("Login with accepted credentials");
        user = new User(username, "");
        loginPage.fillUsernameInput(user);
    }

    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        user.setPassword(password);
        loginPage.fillPasswordInput(user);
    }

    @When("I hit the Login button")
    public void iHitTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("The title should be {string} in the dashboard")
    public void theTitleShouldBeInTheDashboard(String title) {
        String actualTitle = driver.getTitle();
        log.info("Verifying the title: Expected {}, Actual {}", title, actualTitle);
        Assertions.assertThat(actualTitle).isEqualTo(title);
    }
}
