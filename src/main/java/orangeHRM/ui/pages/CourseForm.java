/*
 * @(#) CourseForm.java Copyright (c) 2019 Jala Foundation .
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

import core.utils.DriverMethods;
import orangeHRM.entities.Courses;
import orangeHRM.ui.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * CourseForm class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class CourseForm extends CourseFormAbstract {

    @FindBy(id = "content")
    private WebElement courseDetailForm;

    @FindBy(id = "addCourse_title")
    private WebElement titleTxtBox;

    @FindBy(css = ".ac_input")
    private WebElement coordinatorTxtBox;

    @FindBy(css = "div [data-activates='select-options-dfa8c174-1fda-a6b0-0ddd-234d05fc2c0b']")
    private WebElement subUnitTxtBox;

    @FindBy(css = "div [data-activates='select-options-045ad5be-361a-a563-272d-8db641d17d53']")
    private  WebElement versionTxtBox;

    @FindBy(css = "div [data-activates='select-options-864ee902-b7fd-b9d9-0604-06748d972f5c']")
    private  WebElement subVersionTxtBox;

    @FindBy(css = "div [data-activates='select-options-8b28ca02-5e14-8cc1-5c49-05a85aaee50b']")
    private  WebElement currencyTxtBox;

    @FindBy(id = "addCourse_cost")
    private WebElement costTxtBox;

    @FindBy(id = "addCourse_company")
    private WebElement companyTxtBox;

    @FindBy(id = "addCourse_duration")
    private WebElement durationTxtBox;

    @FindBy(id = "addCourse_description")
    private WebElement descriptionTxtBox;

    @FindBy(id = "btnSaveCourse")
    private WebElement saveBtn;

    @FindBy(css = ".toast-message")
    private WebElement confirmationMessage;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(courseDetailForm));
    }

    /**
     * Sets the title.
     *
     * @param title of type String
     */
    public void setTitle(final String title) {
        DriverMethods.setTxt(titleTxtBox, title);
    }

    /**
     * Sets the coordinator.
     *
     * @param coordinator of type String
     */
    public void setCoordinator(final String coordinator) {
        DriverMethods.setTxt(coordinatorTxtBox, coordinator);
        coordinatorTxtBox.sendKeys(Keys.ENTER);
    }

    /**
     * Sets the subunit.
     *
     * @param subunit for the contact.
     */
    protected void setSubunit(final String subunit) {
        DriverMethods.setTxt(subUnitTxtBox, subunit);
    }

    /**
     * Clicks on save button.
     */
    public void clickSaveBtn() {
        saveBtn.click();
    }

    /**
     * Gets message of saved.
     *
     * @return the message.
     */
    public String getMessageSave() {
        return confirmationMessage.getText();
    }
}