/*
 * @(#) CourseStep.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import orangeHRM.PageTransporter;
import orangeHRM.entities.Context;
import orangeHRM.entities.Courses;
import orangeHRM.ui.pages.CourseForm;
import orangeHRM.ui.pages.CoursePage;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * steps.CourseStep class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class CourseStep {

    PageTransporter pageTransporter;
    private CoursePage coursePage;
    private CourseForm courseForm;
    Context context;
    Courses courses;

    public CourseStep(Context context) {
        this.context = context;
        courses = context.getCourses();

    }

    @When("^I go to the Courses page$")
    public void goToTheCoursesPage() {
        pageTransporter = PageTransporter.getInstance();
        coursePage = pageTransporter.navigateToCoursePage();
    }

    @And("^I open Course form$")
    public void openCoursesForm() {
        courseForm = coursePage.clickAddCourseForm();
    }

    @And("^I create a new Course with the following information in Course form$")
    public void createANewCourseWithTheFollowingInformationInCourseForm(Map<String, String> course) {
        courseForm.setTitle(course.get("Title"));
        courseForm.setCoordinator(course.get("Coordinator"));
        courseForm.clickSaveBtn();
        courses.setTitle(course.get("Title"));
        courses.setCoordinator(course.get("Coordinator"));
    }

    @Then("^a message that indicates the Course was created should be displayed$")
    public void displayMessageThatIndicatesTheCourseWasCreatedShouldBeDisplayed() {
        final String message = courseForm.getMessageSave();
        assertEquals(message, "Successfully Updated");
    }
}