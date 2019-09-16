/*
 * @(#) Permalink.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package orangeHRM.ui;

import java.util.HashMap;
import java.util.Map;

/**
 * Permalink class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public final class Permalink {

    public static final String LOGIN_PAGE = "auth/login";
    public static final String DASHBOARD_PAGE = "client/#/dashboard";
    public static final String COURSE_PAGE = "client/#/noncore/training/viewCourseList";
    private static Map<String, String> course = new HashMap<>();
    static {
        course.put("LOGIN_PAGE", LOGIN_PAGE);
        course.put("DASHBOARD_PAGE", DASHBOARD_PAGE);
        course.put("COURSE_PAGE", COURSE_PAGE);
    }

    /**
     * Gets of course map.
     *
     * @param urlKey of type string.
     * @return value of map.
     */
    public static String getPermalink(final String urlKey) {
            return course.get(urlKey);
    }

    /**
     * Constructor private.
     */
    private Permalink() { }

}