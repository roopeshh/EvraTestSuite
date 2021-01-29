@login
Feature: Testing login functionality
  Background:
    Given user is on the login page

  @smoke @regression @implemented @1
  Scenario: To login with valid login credentials
    When user logs in with valid credentials
    Then user should be logged in to the app

  @smoke @regression @implemented
  Scenario: To login with invalid login credentials
    When user logs in with invalid credentials
    Then user should get error on login page

  @regression @implemented
  Scenario: To validate email field on login page
    When user enters "password" and leaves "email" blank
    And clicks on login button
    Then user should see validation error for "email" field

  @regression @implemented
  Scenario: To validate password field on login page
    When user enters "email" and leaves "password" blank
    And clicks on login button
    Then user should see validation error for "password" field

  @regression @implemented
  Scenario: To validate the email and password fields when blank
    When user leaves both email and password blank
    And clicks on login button
    Then user should see validation error for both the fields