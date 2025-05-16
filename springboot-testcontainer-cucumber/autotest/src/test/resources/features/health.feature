Feature: Health API

  Scenario: Health API is OK
    Given application is up
    When the user publishes a planet named "Earth"
    Then the application must receive