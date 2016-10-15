Feature: Login to application
  Scenario: Login with existing credentials
    Given user opens app
    When user logs in with existing credentials
    And page is loaded
    Then the main page of mobile version is opened
    And user is logged in