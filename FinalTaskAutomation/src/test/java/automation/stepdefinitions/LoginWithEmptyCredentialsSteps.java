package automation.stepdefinitions;

import automation.model.User;
import automation.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginWithEmptyCredentialsSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginWithEmptyCredentialsSteps.class);
    private User user;
    private WebDriver driver = Hooks.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        log.info("Opening the login page");
        loginPage.openPage();
    }

    // UC - 1, 2

    @When("I type credentials into Username {string} and Password {string} fields")
    public void iTypeCredentialsIntoUsernameAndPasswordFields(String username, String password) {
        log.info("Login with empty credentials");
        user = new User(username, password);
        loginPage.fillUsernameInput(user);
        loginPage.fillPasswordInput(user);
    }

    @When("I clear the {string} input")
    public void iClearTheInputs(String input) {
        switch (input) {
            case "password":
                loginPage.clearPasswordInput();
                break;
            case "all":
                loginPage.clearPasswordInput();
                loginPage.clearUsernameInput();
                break;
        }
    }

    @When("I hit the Login button")
    public void iHitTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the error message: {string}")
    public void iShouldSeeTheErrorMessage(String expectedMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        log.info("Verifying error message: Expected {}, Actual {}", expectedMessage, actualErrorMessage);
        Assertions.assertThat(actualErrorMessage).isEqualTo(expectedMessage);
    }

    // UC -3

    @When("^I type Accepted username into Username field$")
    public void iTypeAcceptedUsername(DataTable dataTable) {
        log.info("Login with accepted credentials");
        List<List<String>> rows = dataTable.asLists();
        user = new User(rows.get(0).get(0), "");
        //user.setUsername(rows.get(0).get(0));
        loginPage.fillUsernameInput(user);
    }

    @When("^I enter password$")
    public void iEnterPassword(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists();
        user.setPassword(rows.get(0).get(0));
        loginPage.fillPasswordInput(user);
    }

    @Then("The title should be {string} in the dashboard")
    public void theTitleShouldBeInTheDashboard(String title) {
        String actualTitle = driver.getTitle();
        log.info("Verifying the title: Expected {}, Actual {}", title, actualTitle);
        Assertions.assertThat(actualTitle).isEqualTo(title);
    }

}
