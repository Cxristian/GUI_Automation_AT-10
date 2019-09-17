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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import orangeHRM.PageTransporter;
import orangeHRM.entities.Context;
import orangeHRM.entities.Courses;
import orangeHRM.ui.pages.CourseForm;
import orangeHRM.ui.pages.CourseFormAbstract;
import orangeHRM.ui.pages.CoursePage;
import org.junit.Assert;

import java.util.Map;

/**
 * steps.CourseStep class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class CourseStep {

    private PageTransporter pageTransporter;
    private CoursePage coursePage;
    private CourseForm courseForm;
    private CourseFormAbstract courseFormAbstract;
    private Context context;
    private Courses courses;

    /**
     * Constructor of course steps sending the context.
     *
     * @param context init the context.
     */
    public CourseStep(final Context context) {
        this.context = context;
        courses = context.getCourses();

    }

    /**
     * Open the course form.
     */
    @When("^I open Course form$")
    public void openCoursesForm() {
        coursePage = new CoursePage();
        courseForm = coursePage.clickAddCourseForm();
    }

    /**
     * Creates a new course sending the information.
     *
     * @param course contains the course values
     */
    @When("^I create a new Course with the following information in Course form$")
    public void createANewCourseWithTheFollowingInformationInCourseForm(final Map<String, String> course) {
        courseForm.createCourse(course);
        courses.processInformation(course);
        courseForm.clickSaveBtn();
    }

    /**
     * Verifies with a message of confirmation that the contact is saved.
     */
    @Then("^a message that indicates the Course was created should be displayed$")
    public void displayMessageThatIndicatesTheCourseWasCreatedShouldBeDisplayed() {
        final String message = courseForm.getMessageSave();
        Assert.assertEquals(message, "Successfully Updated");
    }

    /**
     * Verifies the title the new course.
     */
    @Then("^the Course title should be displayed in the course list in the Course page$")
    public void verifyTitleTheNewCourseShouldBeDisplayedInTheCourseListInTheCoursePage() {
        coursePage = new CoursePage();
        Assert.assertTrue(coursePage.isDisplayedTitleCourse(courses.getTitle()));
    }

    /**
     * delete course page.
     */
    @When("^I delete all courses in the Course List page$")
    public void deleteAllCoursesInTheCourseListPage() {
        coursePage = new CoursePage();
        coursePage.deleteNewCourseCreated();
    }

    /**
     * Verifies the message of delete the new course.
     */
    @Then("^I see a message to confirm$")
    public void verifySeeAMessageToConfirm() {
        Assert.assertEquals(coursePage.messageBeforeDelete(), "Successfully Deleted");
    }

    /**
     * verifies delete courses.
     */
    @Then("^the Course title should be removed from Courses List page$")
    public void verifyCourseTitleShouldBeRemovedFromCoursesListPage() {
        Assert.assertFalse(coursePage.isDisplayedTitleCourse("Docker2.0"));
    }
}
