/*
 * @(#) CourseFormAbstract.java Copyright (c) 2019 Jala Foundation .
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

import core.IStrategySetter;
import orangeHRM.ui.BasePage;

import java.util.HashMap;
import java.util.Map;

import static orangeHRM.keys.CourseKeys.COMPANY;
import static orangeHRM.keys.CourseKeys.COORDINATOR;
import static orangeHRM.keys.CourseKeys.COST;
import static orangeHRM.keys.CourseKeys.CURRENCY;
import static orangeHRM.keys.CourseKeys.DESCRIPTION;
import static orangeHRM.keys.CourseKeys.DURATION;
import static orangeHRM.keys.CourseKeys.SUBUNIT;
import static orangeHRM.keys.CourseKeys.SUB_VERSION;
import static orangeHRM.keys.CourseKeys.TITLE;
import static orangeHRM.keys.CourseKeys.VERSION;

/**
 * CourseFormAbstract class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public abstract class CourseFormAbstract extends BasePage {

    /**
     * Process information for composing the strategy map.
     *
     * @param newCourse of type string
     */
    public void createCourse(final Map<String, String> newCourse) {
        final HashMap<String, IStrategySetter> strategyMap = composeStrategyMap(newCourse);
        newCourse.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
        });
    }

    /**
     * Build the course values.
     *
     * @param newCourse of type String.
     * @return The HashMap
     */
    public HashMap<String, IStrategySetter> composeStrategyMap(final Map<String, String> newCourse) {
        final HashMap<String, IStrategySetter> strategyMap = new HashMap<>();
        strategyMap.put(TITLE, () -> setTitle(newCourse.get(TITLE)));
        strategyMap.put(COORDINATOR, () -> setCoordinator(newCourse.get(COORDINATOR)));
        strategyMap.put(SUBUNIT, () -> setSubunit(newCourse.get(SUBUNIT)));
        strategyMap.put(VERSION, () -> setSubunit(newCourse.get(VERSION)));
        strategyMap.put(SUB_VERSION, () -> setSubunit(newCourse.get(SUB_VERSION)));
        strategyMap.put(CURRENCY, () -> setSubunit(newCourse.get(CURRENCY)));
        strategyMap.put(COST, () -> setSubunit(newCourse.get(COST)));
        strategyMap.put(COMPANY, () -> setSubunit(newCourse.get(COMPANY)));
        strategyMap.put(DURATION, () -> setSubunit(newCourse.get(DURATION)));
        strategyMap.put(DESCRIPTION, () -> setSubunit(newCourse.get(DESCRIPTION)));
        return strategyMap;
    }

    /**
     * Sets the title sending a string.
     *
     * @param title for the contact.
     */
    protected abstract void setTitle(String title);

    /**
     * Sets the coordinator sending a string.
     *
     * @param coordinator for the contact.
     */
    protected abstract void setCoordinator(String coordinator);

    /**
     * Sets the subunit sending a string.
     *
     * @param subunit for the contact.
     */
    protected abstract void setSubunit(String subunit);

}