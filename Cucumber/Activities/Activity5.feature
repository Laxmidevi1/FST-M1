@activity5
Feature: Data driven test with Examples

  Scenario Outline: Testing with Data from Scenario
    Given User is on Login page
    When User enters "<Usernames>" and "<Password>"
    Then Read the page title and confirmation message


    Examples:

      | Usernames | Password  |
      | admin     | password  |
      | admin1    | password1 |