/*
 * @(#) LoginSteps.java Copyright (c) 2019 Jala Foundation .
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

import core.utils.Logs;
import cucumber.api.java.en.When;
import orangeHRM.PageTransporter;
import orangeHRM.ui.pages.LoginPage;

/**
 * LoginSteps class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class LoginSteps {

    private PageTransporter pageTransporter;
    private LoginPage loginPage;

    /**
     * Sign in step.
     *
     * @param userName of type String
     * @param password of type String
     */
    @When("^I am logged in orangeHRM site with (username) and (password) valid$")
    public void logInOrangeHRMSiteWithUsernameAndPasswordValid(final String userName, final String password) {
        pageTransporter = PageTransporter.getInstance();
        loginPage = pageTransporter.navigateToLoginPage();
        loginPage.login(userName, password);
        Logs.getInstance().getLog().info("login user");
    }
}
