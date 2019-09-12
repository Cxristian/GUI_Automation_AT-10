/*
 * @(#) DriverMethods.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.utils;

import org.openqa.selenium.WebElement;

/**
 * DriverMethods class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public final class DriverMethods {
    /**
     * Sets the text into the webElement.
     *
     * @param webElement that sets its text.
     * @param text new value of webElement.
     */
    public static void setTxt(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Constructor private.
     */
    private DriverMethods() { }
}