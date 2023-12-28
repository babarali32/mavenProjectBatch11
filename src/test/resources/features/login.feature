Feature: login feature
  Background:
    # Given user navigated to hrms website  //because this line is common in all feature file so put it into hooks, now dont need this line here because this is common.
  @regression @oneTableTwoline
  Scenario Outline: login with valid credentials
    When user enter es different "<username>" and "<password>"
    And user click on login button
    Then user logged in as "<admin>"
    Examples:
      |username|password|admin|
      |Admin    |Hum@nhrm123  |Admin|

    #stars are optional it is for speed of your work
  @regression  @sprint1
    Scenario: login ess user
      When  Ess user enters password and username
      And user click on login button
      Then user logged in as admin
    @negativeLogin
    Scenario Outline: negative login test
      # this scenario is for negative testing
  When user enter es different "<username>" and "<password>" and veryfiy the "<errormsge>" for all combination
      Examples:
      |username|password|errormsge|
      |Admin    |wrongpass   |Invalid credentials        |
      |wronguser|Hum@nhrm123 |Invalid credentials        |
      |         | Hum@nhrm123|Username cannot be empty   |
      |Admin    |            |Password cannot be empty   |