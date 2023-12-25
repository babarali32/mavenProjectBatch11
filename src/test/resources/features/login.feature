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
    @negativeLogin
    Scenario Outline: negative login test
      # this scenario is for negative testing
  When user enteres different "<username>" and "<password>" and veryfiy the "<errormsge>" for all combination
      Examples:
      |username|password|errormsge|
      |Admin    |wrongpass   |Invalid credentials        |
      |wronguser|Hum@nhrm123 |Invalid credentials        |
      |         | Hum@nhrm123|Username cannot be empty   |
      |Admin    |            |Password cannot be empty   |