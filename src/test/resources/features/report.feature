@report
Feature: Testing report functionality

  Background:
    Given user is logged in to the app

  @regression @implemented
  Scenario: Add valuation details for a property
    When user enters the address in the search text field
    And selects the address from the dropdown
    And user clicks on run property
    And user is in the "report" page
    And submit "valuation" details
    Then user should see calculated "valuation" estimate

  @notImplemented
  Scenario: Add sales comps details for a property
    When user enters the address in the search text field
    And selects the address from the dropdown
    And user clicks on run property
    And user is in the "report" page
    And submit "sales comps" details
    Then user should see calculated "sales comps" estimate

  @regression @implemented
  Scenario: Compare neighborhood details in overview and neighbourhood menu
    When user enters the address in the search text field
    And selects the address from the dropdown
    And user clicks on run property
    And user is in the "report" page
    Then user should see "neighborhood" details matching in overview and "neighborhood" menu

  @notImplemented
  Scenario: Compare benchmark details in overview and benchmarks menu
    When user enters the address in the search text field
    And selects the address from the dropdown
    And user clicks on run property
    And user is in the "report" page
    Then user should see "benchmarks" details matching in overview and "benchmarks" menu

  @regression @implemented
  Scenario: Compare valuation details in overview and valuation menu
    When user enters the address in the search text field
    And selects the address from the dropdown
    And user clicks on run property
    And user is in the "report" page
    And submit "valuation" details
    Then user should see "valuation" details matching in overview and "valuation" menu