/*
 * @(#) DashboardStep.java Copyright (c) 2019 Jala Foundation .
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

import core.selenium.WebDriverManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import orangeHRM.PageTransporter;
import orangeHRM.ui.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * DashboardStep class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class DashboardStep {

    PageTransporter pageTransporter;
    DashboardPage dashboardPage;
    WebDriver webDriver;

    @Then("^I am on the Dashboard page$")
    public void verifyOnTheDashboardPage() {
        pageTransporter = PageTransporter.getInstance();
        dashboardPage = pageTransporter.navigateToDashboardPage();
        webDriver = WebDriverManager.getInstance().getWebDriver();
        String title = webDriver.getTitle();
        Assert.assertEquals(title,"OrangeHRM");
    }

    @And("^I see the name (.*) on the dashboard page$")
    public void checkTheNameDashboardOnTheDashboardPage(final String namePage) {
        Assert.assertEquals(dashboardPage.getTitlePage(),namePage);
    }

}
