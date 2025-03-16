Feature: Saucedemo Login
    Background:
        Given: I open the "https://www.saucedemo.com/"

    Scenario Outline: Login with empty credentials
        When: I type credentials into "Username" "<username>"  and "Password" "<password>" fields
        And: I clear the inputs
        And: I hit the "Login" button
        Then: I should see the error message: "Username is required"

        Examples:
        | username | password |
        | user     | 1111     |

    Scenario Outline: Login with Username credentials
        When: I type any credentials in username "<username>"
        And: I enter password "<password>"
        And: I clear the "Password" input
        And: I hit the "Login" button
        Then: I should see the error message: "Password is required"

        Examples:
        | username | password |
        | user     | 1111     |

    Scenario Outline: Login with credentials
        When: I type credentials in "<username>" which are under Accepted username are sections
        And: I enter "<password>" as secret sauce.
        And: Click on Login
        Then: The title should be “Swag Labs” in the dashboard

        Examples:
        | username | password |
        | user     | 1111     |