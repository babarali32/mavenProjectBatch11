Feature: login feature
  Scenario: login with valid credentials
    Given user navigated to hrms website
    When user enters password and username
    And user click on login button
    Then user logged in as admin