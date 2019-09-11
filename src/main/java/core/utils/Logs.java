/*
 * @(#) Logs.java Copyright (c) 2019 Jala Foundation .
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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Logs class.
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public final class Logs {
    private static Logs instance = null;
    protected static final  Logger LOG = Logger.getLogger(Logs.class);
    private static final String LOG_4_J_PROPERTIES = "log.properties";

    /**
     * Is the private constructor of our Singleton class.
     */
    private Logs() {
        super();
    }

    /**
     * A instance is created at the beginning and
     * if it just was created, returns just the object created
     * It has a log4j.properties to config the syntax's logs. That
     * file is in the folder resources
     * @return Logger
     */
    public static Logs getInstance() {
        if (instance == null) {
            instance = new Logs();
            PropertyConfigurator.configure(LOG_4_J_PROPERTIES);
            LOG.setLevel(Level.ALL);
        }
        return instance;
    }

    /**
     * @return Logger LOG to do our loggers
     */
    public Logger getLog() {
        return LOG;
    }
}
