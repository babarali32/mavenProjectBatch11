Feature: userStorye-101 search employee
  Background:
    Given user navigated to hrms website
    When user enters password and username
    And user click on login button
    Then user logged in as admin
  @smoke
  Scenario: search employe by id
    When user navigate to employe list
    When user enters valid employe id
    And click on search button
    Then user see the employe information
    Then user close the browser
  @regression
  Scenario: search employe by name
    When user navigate to employe list
    When user enters valid employe name
    And click on search button
    Then user see the employe information
    Then user close the browser
