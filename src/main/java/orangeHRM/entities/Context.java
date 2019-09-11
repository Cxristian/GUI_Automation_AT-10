/*
 * @(#) Context.java Copyright (c) 2019 Jala Foundation.
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
 * Context class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class Context {

    private Courses courses;

    /**
     * Context for creation of the constructor.
     */
    public Context() {
        this.courses = new Courses();
    }

    /**
     * Returns the Courses of context.
     *
     * @return courses.
     */
    public Courses getCourses() {
        return courses;
    }
}
