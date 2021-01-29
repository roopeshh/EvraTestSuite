@search
Feature: Testing search functionality

  Background:
    Given user is logged in to the app

  @smoke @regression @implemented
  Scenario: To search for a property
    When user enters the address in the search text field
    And selects the address from the dropdown
    And user clicks on run property
    Then user should see results for the address searched

  @regression @implemented
  Scenario: User gets error message on not selecting the address from the dropdown
    When user enters the address in the search text field
    And user clicks outside the text field
    Then user should get an error message to select address from the dropdown

  @regression @implemented
  Scenario: User gets error message on entering address without street number
    When user enters invalid address in the search text field
    And selects the address from the dropdown
    Then user should get wrong address error message