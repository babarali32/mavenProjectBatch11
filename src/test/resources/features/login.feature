Feature: login feature
  Background:
    Given user navigated to hrms website
  @smoke
  Scenario: login with valid credentials
    When user enters password and username
    And user click on login button
    Then user logged in as admin
  @regression @smoke @sprint1 @sprint2
    Scenario: login ess user
      When  Ess user enters password and username
      And user click on login button
      Then user logged in as admin