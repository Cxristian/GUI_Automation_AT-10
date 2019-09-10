/*
 * @(#) FactoryBrowser.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.selenium.webDrivers;

import core.selenium.WebDriverConfig;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * FactoryBrowser class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public final class FactoryBrowser {

    private static WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";

    /**
     * Return the object of the Driver that will use.
     *
     * @return webDriver for the browser.
     */
    public static WebDriver getWebDriver() {
        Map<String, IDriver> strategyBrowser = new HashMap<>();
        strategyBrowser.put(FIREFOX, new Firefox());
        strategyBrowser.put(CHROME, new Chrome());
        return strategyBrowser.get(webDriverConfig.getBrowser().toLowerCase()).initDriver();
    }

    /**
     * Constructor.
     */
    private FactoryBrowser() {
    }
}
