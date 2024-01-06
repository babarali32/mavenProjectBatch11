Feature: add an employe on hrms
  Background:
    Given user navigated to hrms website
    When user enters password and username
    And user click on login button
    Then user logged in as admin
    When user clicks on PIM button
    And user clicks on ADD employee button
  @dropdown
  Scenario: add employee in feature file
    And user add first name and last name
    And user clicks on save button
    Then employee added successfully
    Then user close the browser
    @addEmployee
    Scenario Outline:
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
    @javascriptclick
    Scenario:
      And user enters direct data "pakistan" and middle "lahore" and "kasur" last name
      And user clicks on save button
      Then employee added successfully
      Then user close the browser

      @tableData
      Scenario: add employee
       When user add multiple employees and verigy they added
       |firstName|  middleName   |  lastName    |
       |  wash10  |    dry40     |     press70  |
       |  clean20 |   tie50      |     wear80   |
       |  bat30   |    ball60    |    ground90  |

       @excel
       Scenario: add emoloyee data from excel file
       When user adds multiply employees from the "list" sheet and verify the added employees