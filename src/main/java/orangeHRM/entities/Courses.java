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

/**
 * Courses class
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class Courses {

    private String title;
    private String coordinator;
    private String subunit;

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
    public void setTitle(String title) {
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
    public void setCoordinator(String coordinator) {
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
    public void setSubunit(String subunit) {
        this.subunit = subunit;
    }
}