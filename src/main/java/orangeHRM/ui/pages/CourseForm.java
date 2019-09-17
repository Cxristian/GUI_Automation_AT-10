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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * CourseForm class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class CourseForm extends CourseFormAbstract {

    @FindBy(id = "content")
    private WebElement courseDetailForm;

    @FindBy(id = "addCourseTitle")
    private WebElement titleLabel;

    @FindBy(id = "addCourse_title")
    private WebElement titleTxtBox;

    @FindBy(css = ".ac_input")
    private WebElement coordinatorTxtBox;

    @FindBy(id = "addCourse_subunit")
    private WebElement subUnitListBox;

    @FindBy(id = "addCourse_versionFirst")
    private  WebElement versionListBox;

    @FindBy(id = "addCourse_versionSecond")
    private  WebElement subVersionListBox;

    @FindBy(id = "addCourse_currency")
    private  WebElement currencyListBox;

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
        Select selectElement = new Select(subUnitListBox);
        selectElement.selectByVisibleText(subunit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subUnitListBox);
    }

    /**
     * Sets the version.
     *
     * @param version for the contact.
     */
    protected void setVersion(final String version) {
        Select selectElement = new Select(versionListBox);
        selectElement.selectByValue(version);
    }

    /**
     * Sets the subVersion.
     *
     * @param subVersion for the contact.
     */
    protected void setSubVersion(final String subVersion) {
        Select selectElement = new Select(subVersionListBox);
        selectElement.selectByValue(subVersion);
    }

    /**
     * Sets the currency.
     *
     * @param currency for the contact.
     */
    protected void setCurrency(final String currency) {
        Select selectElement = new Select(currencyListBox);
        selectElement.selectByValue(currency);
    }

    /**
     * Sets the cost.
     *
     * @param cost of type String
     */
    public void setCost(final String cost) {
        DriverMethods.setTxt(costTxtBox, cost);
    }

    /**
     * Sets the company.
     *
     * @param company of type String
     */
    public void setCompany(final String company) {
        DriverMethods.setTxt(companyTxtBox, company);
    }

    /**
     * Sets the duration.
     *
     * @param duration of type String
     */
    public void setDuration(final String duration) {
        DriverMethods.setTxt(durationTxtBox, duration);
    }

    /**
     * Sets the description.
     *
     * @param description of type String
     */
    public void setDescription(final String description) {
        DriverMethods.setTxt(descriptionTxtBox, description);
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

    /**
     * Gets title before of saved.
     *
     * @return text of title.
     */
    public String getTitleCourseDetails() {
        return titleLabel.getText();
    }
}
