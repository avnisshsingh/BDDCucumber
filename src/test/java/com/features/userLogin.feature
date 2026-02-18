Feature: User Login Functionality

  Scenario: user logins with valid credentials
    Given user is on Login Page
    When user enters valid login credentials
    Then user should be redirected to product list page
