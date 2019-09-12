Feature: Manage courses

  Background:
  Given I log in orangeHRM site with username and password valid
    And I am on the Dashboard page

  Scenario: Create a new Course with only required data
    When I go to the Courses page
      And I open Course form
      And I create a new Course with the following information in Course form
        | Title       | Docker2.0 |
        | Coordinator | 112       |
    Then a message that indicates the Course was created should be displayed
      And the Course title should be displayed in the course list in the Course page

#  Scenario: Create a new Course with all data
#    When I go to the Courses page
#      And I open Course form
#      And I create a new Course with the following information in Course form
#        | Title       | Docker3.0          |
#        | Coordinator | 112                |
#        | Subunit     | QA Team            |
#        | Version     | 1                  |
#        | Sub version | 0                  |
#        | Currency    | Bolivian Boliviano |
#        | Cost        | 0                  |
#        | Company     | AT-10              |
#        | Duration    | 01:00              |
#        | Description | no                 |
#    Then a message that indicates the Course was created should be displayed
#      And the Course title should be displayed in the course list in the Course page
#
#  Scenario: Delete a course that was created
#    Given I have a Course with title "Course to delete"
#    When I go to the Courses page
#      And I open Courses List page
#      And I delete the Course in the Course List page
#      And I see a message to confirm
#    Then the Course title should de removed from Courses List page
