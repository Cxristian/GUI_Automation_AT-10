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

package audiomack.ui.pages;
import core.utils.ReaderPropertiesFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import audiomack.ui.BasePage;

/**
 * LoginPage class
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class LoginPage extends BasePage {

    @FindBy(id = "react-view")
    WebElement audiomackForm;

    @FindBy(css = "div[class='main-header__right u-right'] a[data-modal='login']")
    WebElement loginBtn;

    @FindBy(name = "email")
    WebElement emailTxtBox;

    @FindBy(css = "button[class='button auth__button auth__button--submit u-text-center u-fs-14 u-fw-700']")
    WebElement continueBtn;

    @FindBy(id = "password")
    WebElement passwordTxtBox;

    @FindBy(css = ".button--padded")
    WebElement signInBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(audiomackForm));
    }

    /**
     * Log in in the application.
     *
     * @param userName of the user.
     * @param password of the user.
     */
    public void login(String userName, String password) {
        setUserName(ReaderPropertiesFile.getInstance().getProperties().get(userName));
        clickContinueBtn();
        setPassword(ReaderPropertiesFile.getInstance().getProperties().get(password));
        clickSignInBtn();
    }

    /**
     * Clicks on login button.
     */
    public void clickLogin() {
        loginBtn.click();
    }

    /**
     * Clicks on continue button.
     */
    public void clickContinueBtn() {
        continueBtn.click();
    }

    /**
     * Clicks on SignIn button.
     */
    public void clickSignInBtn() {
        signInBtn.click();
    }

    /**
     * Sets the user name in the textBox of the login form.
     *
     * @param userName for the log in.
     */
    public void setUserName(String userName) {
        emailTxtBox.sendKeys(userName);
    }

    /**
     * Sets the password in the textBox of the login form.
     *
     * @param password for the log in.
     */
    public void setPassword(String password) {
        passwordTxtBox.sendKeys(password);
    }
}
