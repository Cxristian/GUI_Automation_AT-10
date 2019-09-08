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

import cucumber.api.java.en.Given;
import audiomack.PageTransporter;
import audiomack.ui.pages.LoginPage;

/**
 * LoginSteps class
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class LoginSteps {

    PageTransporter pageTransporter = PageTransporter.getInstance();
    private LoginPage loginPage;

    /**
     * Sign in step.
     */
    @Given("^I am logged in Audiomack site with (username) and (password) valid$")
    public void LogInAudiomackSiteWithUsernameAndPasswordValid(final String userName, final String password) {
        loginPage = pageTransporter.navigateToLoginPage();
        loginPage.clickLogin();
        loginPage.login(userName, password);
    }
}