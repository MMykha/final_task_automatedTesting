Feature: Login Feature

    Background:
        Given I open the login page

    Scenario: Login with empty credentials
        When I type credentials into Username "<username>" and Password "<password>" fields
        And I clear the inputs
        And I hit the Login button
        Then I should see the error message: "Username is required"

        Examples:
            | username | password     |
            | any_user | any_password |

    Scenario: Login with Username credentials
        When I type any credentials in username "<username>"
        And I enter password "<password>"
        And I clear the Password input
        And I hit the Login button
        Then I should see the error message: "Password is required"

        Examples:
            | username | password     |
            | any_user | any_password |

    Scenario: Login with credentials
        When I type Accepted username "<username>" into Username field
        And I enter password as "<password>"
        And I hit the Login button
        Then The title should be “Swag Labs” in the dashboard

        Examples:
            | username      | password     |
            | standard_user | secret_sauce |