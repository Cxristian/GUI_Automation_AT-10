/*
 * @(#) Courses.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package orangeHRM.entities;

import core.IStrategySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Courses class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class Courses {

    private String title;
    private String coordinator;
    private String subunit;

    /**
     * Process information for composing the strategy map.
     *
     * @param newCourse of type string
     */
    public void processInformation(final Map<String, String> newCourse) {
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
     * Gets the title of the Course.
     *
     * @return the id as string.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of Course.
     *
     * @param title for the account.
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the coordinator of the Course.
     *
     * @return the id as string.
     */
    public String getCoordinator() {
        return coordinator;
    }

    /**
     * Sets the coordinator of Course.
     *
     * @param coordinator for the account.
     */
    public void setCoordinator(final String coordinator) {
        this.coordinator = coordinator;
    }

    /**
     * Gets the subunit of the Course.
     *
     * @return the subunit as string.
     */
    public String getSubunit() {
        return subunit;
    }

    /**
     * Sets the subunit of Course.
     *
     * @param subunit for the account.
     */
    public void setSubunit(final String subunit) {
        this.subunit = subunit;
    }
}
