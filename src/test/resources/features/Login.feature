
Feature: Log In in the orangeHRM Application

  Scenario: Login in the orangeHRM application
    Given I go to the LOGIN_PAGE
    When I log in orangeHRM site with username and password valid
    Then I am on the DASHBOARD_PAGE
      And I see the name Dashboard on the dashboard page
