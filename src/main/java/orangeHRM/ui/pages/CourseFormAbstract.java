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

/**
 * CourseFormAbstract class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public abstract class CourseFormAbstract extends BasePage {

    private String title;
    private String coordinator;
    private String subunit;

    /**
     * Process information for composing the strategy map.
     *
     * @param newCourse of type string
     */
    public void setCourseInformation(final Map<String, String> newCourse) {
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
        strategyMap.put(title, () -> setTitle(newCourse.get(title)));
        strategyMap.put(coordinator, () -> setCoordinator(newCourse.get(coordinator)));
        strategyMap.put(subunit, () -> setSubunit(newCourse.get(subunit)));
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