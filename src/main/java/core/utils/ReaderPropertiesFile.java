/*
 * @(#) ReaderPropertiesFile.java Copyright (c) 2019 Jala Foundation .
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReaderPropertiesFile {

    private static final String URL_DRIVER_PROPERTIES = "driver.properties";
    private static final String URL_GRADLE_PROPERTIES = "gradle.properties";

    private Map<String, String> properties;

    /**
     * Initializes a new reader with the properties for driver.
     */
    protected ReaderPropertiesFile() {
        properties = new HashMap<>();
        addPropertiesGradle();
        addPropertiesDriver();
    }

    /**
     * Gets the properties of map.
     *
     * @return driver properties.
     */
    public Map<String, String> getProperties() {
        return properties;
    }

    /**
     * Adds properties for the Audiomack to map applicationProperties.
     */
    public void addPropertiesGradle() {
        Properties propertiesGradle = loadFile(URL_GRADLE_PROPERTIES);
        propertiesGradle.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    }

    /**
     * Adds the properties of driver.properties file to the map.
     */
    public void addPropertiesDriver() {
        Properties propertiesGradle = loadFile(URL_DRIVER_PROPERTIES);
        propertiesGradle.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    }

    /**
     * Initializes a new reader for properties.
     *
     * @return a ReaderDriverProperties.
     */
    public static ReaderPropertiesFile getInstance() {
        return new ReaderPropertiesFile();
    }

    /**
     * Loads a property file.
     *
     * @param url of properties.
     * @return the properties.
     */
    private Properties loadFile(final String url) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream(url);
            // load a properties file
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
