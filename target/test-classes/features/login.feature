Feature: login feature
  Background:
   # Given user navigated to hrms website
  @regression
  Scenario: login with valid credentials
    * user enters password and username
    * user click on login button
    * user logged in as admin
  @regression  @sprint1 @sprint2
    Scenario: login ess user
      * Ess user enters password and username
      * user click on login button
      * user logged in as admin