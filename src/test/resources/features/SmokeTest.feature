Feature: Open web application
  @ignore
  Scenario: Check mobile device is recognized by app
    Given user opens app
    When page is loaded
    Then the main page of mobile version is opened
