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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
 * Courses class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class Courses {

    private String title;
    private String coordinator;
    private String subunit;
    private String version;
    private String subVersion;
    private String currency;
    private String cost;
    private String company;
    private String duration;
    private String description;
    private Set<String> courseKeys = new HashSet<String>();

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
        strategyMap.put(TITLE, () -> setTitle(newCourse.get(TITLE)));
        strategyMap.put(COORDINATOR, () -> setCoordinator(newCourse.get(COORDINATOR)));
        strategyMap.put(SUBUNIT, () -> setSubunit(newCourse.get(SUBUNIT)));
        strategyMap.put(VERSION, () -> setVersion(newCourse.get(VERSION)));
        strategyMap.put(SUB_VERSION, () -> setSubVersion(newCourse.get(SUB_VERSION)));
        strategyMap.put(CURRENCY, () -> setCurrency(newCourse.get(CURRENCY)));
        strategyMap.put(COST, () -> setCost(newCourse.get(COST)));
        strategyMap.put(COMPANY, () -> setCompany(newCourse.get(COMPANY)));
        strategyMap.put(DURATION, () -> setDuration(newCourse.get(DURATION)));
        strategyMap.put(DESCRIPTION, () -> setDescription(newCourse.get(DESCRIPTION)));
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
        courseKeys.add(TITLE);
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
        courseKeys.add(COORDINATOR);
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
        courseKeys.add(SUBUNIT);
    }

    /**
     * Gets the version of the Course.
     *
     * @return the version as string.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the version of Course.
     *
     * @param version for the account.
     */
    public void setVersion(final String version) {
        this.version = version;
        courseKeys.add(VERSION);
    }

    /**
     * Gets the subVersion of the Course.
     *
     * @return the subVersion as string.
     */
    public String getSubVersion() {
        return subVersion;
    }

    /**
     * Sets the subVersion of Course.
     *
     * @param subVersion for the account.
     */
    public void setSubVersion(final String subVersion) {
        this.subVersion = subVersion;
        courseKeys.add(SUB_VERSION);
    }

    /**
     * Gets the currency of the Course.
     *
     * @return the currency as string.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency of Course.
     *
     * @param currency for the account.
     */
    public void setCurrency(final String currency) {
        this.currency = currency;
        courseKeys.add(CURRENCY);
    }

    /**
     * Gets the cost of the Course.
     *
     * @return the cost as string.
     */
    public String getCost() {
        return cost;
    }

    /**
     * Sets the cost of Course.
     *
     * @param cost for the account.
     */
    public void setCost(final String cost) {
        this.cost = cost;
        courseKeys.add(COST);
    }

    /**
     * Gets the company of the Course.
     *
     * @return the company as string.
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company of Course.
     *
     * @param company for the account.
     */
    public void setCompany(final String company) {
        this.company = company;
        courseKeys.add(COMPANY);
    }

    /**
     * Gets the duration of the Course.
     *
     * @return the duration as string.
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration of Course.
     *
     * @param duration for the account.
     */
    public void setDuration(final String duration) {
        this.duration = duration;
        courseKeys.add(DURATION);
    }

    /**
     * Gets the description of the Course.
     *
     * @return the description as string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of Course.
     *
     * @param description for the account.
     */
    public void setDescription(final String description) {
        this.description = description;
        courseKeys.add(DESCRIPTION);
    }

    /**
     * Returns the course keys of the an Event.
     *
     * @return as a set of string the courseKeys.
     */
    public Set<String> getCourseKeys() {
        return courseKeys;
    }
}
