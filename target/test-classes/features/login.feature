Feature: login feature
  Background:
   # Given user navigated to hrms website
  @regression @sprint2
  Scenario: login with valid credentials
    * user enters password and username
    * user click on login button
    * user logged in as admin
    #stars are optional it is for speed of your work
  @regression  @sprint1
    Scenario: login ess user
      When  Ess user enters password and username
      And user click on login button
      Then user logged in as admin