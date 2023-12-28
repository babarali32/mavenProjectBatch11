Feature: dashboard functionality

    @dashboard
    Scenario: verify dashboard functionality
    When user enters password and username
    And user click on login button
    Then user logged in as admin
    Then verify all the dashboard tabs
      |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|

