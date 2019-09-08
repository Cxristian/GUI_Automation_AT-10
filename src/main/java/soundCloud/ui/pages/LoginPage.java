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

package soundCloud.ui.pages;
import core.utils.LoaderPropertiesFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import soundCloud.ui.BasePage;

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

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(audiomackForm));
    }

    public void login(String userName, String password) {
        setUserName(LoaderPropertiesFile.getInstance().getProperties().get(userName));
        clickContinueBtn();
        setPassword(LoaderPropertiesFile.getInstance().getProperties().get(password));
        clickConnectingBtn();
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void clickConnectingBtn() {
        signInBtn.click();
    }

    public void setUserName(String userName) {
        emailTxtBox.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordTxtBox.sendKeys(password);
    }
}
