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

package soundCloud;

import core.selenium.WebDriverManager;
import core.utils.LoaderPropertiesFile;
import org.openqa.selenium.WebDriver;
import soundCloud.ui.pages.LoginPage;

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

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    private void goToURL(final String url) {
        try {
            webDriver.navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public LoginPage navigateToLoginPage() {
        goToURL(LoaderPropertiesFile.getInstance().getProperties().get("login"));
        return new LoginPage();
    }
}