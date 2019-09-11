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
}
