package org.com.epam.ta_training_java.AlionaSachok.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    public static final String ERROR_READ_PROPERTY = "Error, property not found";
    private static final String DEFAULT_FILENAME = "dev.properties";
    private static volatile PropertiesUtils instance = null;

    private Properties appProps;
    private String filename;

    private PropertiesUtils(String filename) {
        this.filename = filename;
        init();
    }

    public static PropertiesUtils get() {
        return get(DEFAULT_FILENAME);
    }

    public static PropertiesUtils get(String filename) {
        if (instance == null) {
            synchronized (PropertiesUtils.class) {
                if (instance == null) {
                    instance = new PropertiesUtils(filename);
                }
            }
        }
        return instance;
    }

    private void init() {
        appProps = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (inputStream == null) {
                throw new IOException("Property file '" + filename + "' not found in the classpath");
            }
            appProps.load(inputStream);
        } catch (IOException e) {
            logger.error("ERROR Reading {}  Message = {}", filename, e.getMessage());
        }
    }

    public String readProperty(String propertyName) {
        return appProps.getProperty(propertyName, ERROR_READ_PROPERTY);
    }

    public String readBaseUrl() {
        return readProperty(ApplicationProperties.BASE_URL.getPropertyName());
    }

    public String readBrowserName() {
        return readProperty(ApplicationProperties.BROWSER_NAME.getPropertyName());
    }

    public String readUserName() {
        return readProperty(ApplicationProperties.USER_NAME.getPropertyName());
    }

    public String readUserPassword() {
        return readProperty(ApplicationProperties.USER_PASSWORD.getPropertyName());
    }
}