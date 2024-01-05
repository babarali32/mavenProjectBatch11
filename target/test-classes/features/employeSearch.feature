Feature: userStorye-101 search employee
  Background:
    When user logged in with valid Amin credentials
    # And user click on login button
    # Then user logged in as admin
  @jsclick
  Scenario: search employe by id
    When user navigate to employe list
    When user enters valid employe id
    And click on search button
    Then user see the employe information
  @name
  Scenario: search employe by name
    When user navigate to employe list
    When user enters valid employe name
    And click on search button
    Then user see the employe information
