/*
 * @(#) DashboardPage.java Copyright (c) 2019 Jala Foundation .
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
 * DashboardPage class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class DashboardPage extends BasePage {

    @FindBy(id = "dashboard-navbar")
    private WebElement dashBoardForm;

    @FindBy(id = "account-name")
    private WebElement userNameLbl;

    @FindBy(css = "div [class='page-title']")
    private WebElement titlePage;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(dashBoardForm));
    }

    /**
     * Gets of user Name.
     *
     * @return User name of page.
     */
    public String getUserName() {
        return userNameLbl.getText();
    }

    /**
     * Gets of title page.
     *
     * @return title of page.
     */
    public String getTitlePage() {
        return titlePage.getText();
    }
}
