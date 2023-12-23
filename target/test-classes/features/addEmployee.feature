Feature: add an employe on hrms

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
    @addEmployee
    Scenario Outline:
      Given user navigated to hrms website
      When user enters password and username
      And user click on login button
      Then user logged in as admin
      When user clicks on PIM button
      And user clicks on ADD employee button
      And user add "<firstName>" and middle "<middleName>" and "<lastName>" last name
      And user clicks on save button
      Then employee added successfully
      Then user close the browser
      Examples:
      |firstName|  middleName | lastName  |
      |   one   |    123      |     abc   |
      |   two   |   456       |     def   |
      |  three  |     789     |    xyz    |
      # 3rd method when you do not want to use scenario outline and scenario hard code data
    @babar
    Scenario:
      Given user navigated to hrms website
      When user enters password and username
      And user click on login button
      Then user logged in as admin
      When user clicks on PIM button
      And user clicks on ADD employee button
      And user enters direct data "rana" and middle "babar" and "ali" last name
      And user clicks on save button
      Then employee added successfully
      Then user close the browser