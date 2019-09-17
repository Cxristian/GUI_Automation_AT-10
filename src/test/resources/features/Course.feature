Feature: Manage courses

  Background:
    Given I go to the LOGIN_PAGE
      And I log in orangeHRM site with username and password valid
      And I am on the DASHBOARD_PAGE

  @deleteCourse
  Scenario: Create a new Course with only required data
    When I go to the COURSE_PAGE
      And I open Course form
      And I create a new Course with the following information in Course form
        | Title       | Docker2.0     |
        | Coordinator | Muhammad Khan |
    Then a message that indicates the Course was created should be displayed
    When I go to the COURSE_PAGE
    Then the Course title should be displayed in the course list in the Course page

  Scenario: Create a new Course with all data
    When I go to the COURSE_PAGE
      And I open Course form
      And I create a new Course with the following information in Course form
        | Title       | Docker2.0          |
        | Coordinator | 112                |
        | Version     | 1                  |
        | Sub version | 0                  |
        | Cost        | 0                  |
        | Company     | AT-10              |
        | Duration    | 01:00              |
        | Description | no                 |
    Then a message that indicates the Course was created should be displayed
    When I go to the COURSE_PAGE
    Then the Course title should be displayed in the course list in the Course page

  Scenario: Delete a course that was created
    Given I go to the COURSE_PAGE
    When I delete all courses in the Course List page
    Then I see a message to confirm
