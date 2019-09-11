/*
 * @(#) LoginPage.java Copyright (c) 2019 Jala Foundation .
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
import core.utils.ReaderPropertiesFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import orangeHRM.ui.BasePage;

/**
 * LoginPage class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class LoginPage extends BasePage {

    @FindBy(id = "wrapper")
    private WebElement orangeHRMForm;

    @FindBy(id = "txtUsername")
    private WebElement userNameTxtBox;

    @FindBy(id = "txtPassword")
    private WebElement passwordTxtBox;

    @FindBy(id = "btnLogin")
    private WebElement logInBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(orangeHRMForm));
    }

    /**
     * Log in in the application.
     *
     * @param userName of the user.
     * @param password of the user.
     */
    public void login(final String userName, final String password) {
        setUserName(ReaderPropertiesFile.getInstance().getProperties().get(userName));
        setPassword(ReaderPropertiesFile.getInstance().getProperties().get(password));
        clickLogin();
    }

    /**
     * Clicks on login button.
     */
    public void clickLogin() {
        logInBtn.click();
    }

    /**
     * Sets the user name in the textBox of the login form.
     *
     * @param userName for the LOG in.
     */
    private void setUserName(final String userName) {
        userNameTxtBox.sendKeys(userName);
    }

    /**
     * Sets the password in the textBox of the login form.
     *
     * @param password for the LOG in.
     */
    private void setPassword(final String password) {
        passwordTxtBox.sendKeys(password);
    }
}
