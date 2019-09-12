
Feature: Log In in the orangeHRM Application

  Scenario: Login in the orangeHRM application
    When I log in orangeHRM site with username and password valid
    Then I am on the Dashboard page
      And I see the name Dashboard on the dashboard page
