Feature: Login Feature

    Background:
        Given I open the login page

    Scenario Outline: Login with empty credentials
        When I type credentials into Username "<username>" and Password "<password>" fields
        And I clear the "<input>" input
        And I hit the Login button
        Then I should see the error message: "<error_message>"

        Examples:
        |username | password | error_message | input|
        |any_user | any_password | Username is required | all|
        |any_user | any_password | Password is required | password |

    Scenario: Login with credentials
        When I type Accepted username into Username field
            | locked_out_user |
        And I enter password
            | secret_sauce |
        And I hit the Login button
        Then The title should be "Swag Labs" in the dashboard
