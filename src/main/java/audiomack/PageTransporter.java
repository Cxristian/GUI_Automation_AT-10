/*
 * @(#) PageTransporter.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package audiomack;

import core.selenium.WebDriverManager;
import core.utils.ReaderPropertiesFile;
import org.openqa.selenium.WebDriver;
import audiomack.ui.pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * PageTransporter class
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class PageTransporter {

    private static PageTransporter instance;
    WebDriver webDriver;

    /**
     * Constructor of page transporter.
     */
    protected PageTransporter() {
        initialize();
    }

    /**
     * Gets instance of page transporter.
     *
     * @return a new instance if it was initialised.
     */
    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    /**
     * Initializes the attributes.
     */
    private void initialize() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Navigates to a page sending the url.
     *
     * @param url for navigate.
     */
    private void goToURL(final String url) {
        try {
            webDriver.navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to the login page.
     *
     * @return a new login page.
     */
    public LoginPage navigateToLoginPage() {
        goToURL(ReaderPropertiesFile.getInstance().getProperties().get("login"));
        return new LoginPage();
    }
}