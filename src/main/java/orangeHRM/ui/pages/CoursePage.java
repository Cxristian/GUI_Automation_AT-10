/*
 * @(#) CoursePage.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package orangeHRM.ui.pages;

import orangeHRM.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * CoursePage class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class CoursePage extends BasePage {

    @FindBy(css = "div[class='nav-wrapper customized-orange']")
    private WebElement coursePage;

    @FindBy(css = "div [class='page-title ']")
    private WebElement namePage;

    @FindBy(css = "i[class='large material-icons']")
    private WebElement addNewCourseBtn;

    @FindBy(id = "frmList_ohrmListComponent_Menu")
    private WebElement optionsBtn;

    @FindBy(id = "frmList_ohrmListComponent_chkSelectAll")
    private WebElement optionSelectedAllBtn;

    @FindBy(id = "deleteBtn")
    private WebElement deleteAllBtn;

    @FindBy(id = "course-delete-button")
    private WebElement messageDeleteYesBtn;

    @FindBy(css = "[class='toast-message']")
    private WebElement messageBeforeDelete;

    private final String TITLE_LIST = "//td[@class=' '][@style='width: 25%'] //a[contains(text(),'titleOfList')]";
    private final String COORDINATOR_LIST =
            "//td[@class=' '][@style='width: 20%'][contains(text(),'coordinatorOfList')]";

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(coursePage));
    }

    /**
     * Gets of name page.
     *
     * @return name of page.
     */
    public String getNamePage() {
        return namePage.getText();
    }


    /**
     * Gets add Course.
     *
     * @return new course form.
     */
    public CourseForm clickAddCourseForm() {
        addNewCourseBtn.click();
        return new CourseForm();
    }

    /**
     * Constructor of page.
     */
    public CoursePage() {
        driver.switchTo().frame(0);
    }

    /**
     * Checks title in Course List.
     *
     * @param title string.
     * @return boolean.
     */
    public boolean isDisplayedTitleCourse(final String title) {
        return driver.findElement(By.xpath(TITLE_LIST.replace("titleOfList", title))).isDisplayed();
    }

    /**
     * Checks coordinator in Course List.
     *
     * @param coordinator string.
     * @return exist coordinator
     */
    public boolean isDisplayedCoordinatorCourse(final String coordinator) {
        return driver.findElement(By.xpath(COORDINATOR_LIST.replace("coordinatorOfList", coordinator))).isDisplayed();
    }

    /**
     * delete new course.
     */
    public void deleteNewCourseCreated() {
        optionsBtn.click();
        optionSelectedAllBtn.click();
        optionsBtn.click();
        deleteAllBtn.click();
        messageDeleteYesBtn.click();
    }

    /**
     * message of delete course.
     *
     * @return message.
     */
    public String messageBeforeDelete() {
        return messageBeforeDelete.getText();
    }
}
