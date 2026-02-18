Feature: User Login Functionality

  Background: Given user is on Login Page

  @Smoke
  Scenario: user logins with valid credentials
    When user enters valid login credentials
    Then user should be redirected to product list page

  @Sanity
  Scenario: User login with InValid Credentials
    When User enters Invalid login credentials
    Then User gets InValid Login error message

  @Sanity @Regression
  Scenario: User login without Credentials
    When User try to login without any credentials
    Then User gets LoginRequired error message
