Feature: userStorye-101 search employee
  Scenario: search employe by id
    Given user navigated to hrms website
    When user enters password and username
    And user click on login button
    Then user logged in as admin
    When user navigate to employe list
    When user enters valid employe id
    And click on search button
    Then user see the employe information
    Then user close the browser

  Scenario: search employe by name
    Given user navigated to hrms website
    When user enters password and username
    And user click on login button
    Then user logged in as admin
    When user navigate to employe list
    When user enters valid employe name
    And click on search button
    Then user see the employe information
    Then user close the browser
