/*
 * @(#) Hooks.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package hooks;

import core.selenium.WebDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * Hooks class.
 *
 * @author Cristian Lujan.
 * @version 0.0.1
 */
public class Hooks {

    private WebDriver webDriver;

    /**
     * Constructor of class.
     */
    public Hooks() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Method for attachment a picture.
     *
     * @param scenario of type scenario;
     */
    @After
    public void embedScreenshot(final Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }
}
