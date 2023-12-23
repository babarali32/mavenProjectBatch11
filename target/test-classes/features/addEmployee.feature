Feature: add an employe on hrms
  @regression
  Scenario: add employee in feature file
    Given user navigated to hrms website
    When user enters password and username
    And user click on login button
    Then user logged in as admin
    When user clicks on PIM button
    And user clicks on ADD employee button
    And user add first name and last name
    And user clicks on save button
    Then employee added successfully
    Then user close the browser