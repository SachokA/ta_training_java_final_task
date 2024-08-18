package org.com.epam.ta_training_java.AlionaSachok.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

enum ApplicationProperties {
    BASE_URL("base.url"),
    BROWSER_NAME("browser.name"),
    USER_NAME("user.name"),
    USER_PASSWORD("user.password");
    private String propertyName;

    private ApplicationProperties(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public String toString() {
        return propertyName;
    }
}

public class PropertiesUtils {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    public static final String ERROR_READ_PROPERTY = "Error, property not found";
    //
    private static final String DEFAULT_FILENAME = "dev.properties";
    private final String PATH_SEPARATOR = "/";
    //
    private static volatile PropertiesUtils instance = null;
    //
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
        String filePath = getFullPath();
        loadProperties(filePath);
    }

    private String getFullPath() {
        String path = this.getClass().getResource(PATH_SEPARATOR + filename).getPath();
        return path;
    }

    private void loadProperties(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            appProps.load(fileInputStream);
        } catch (Exception e) {
            logger.error("ERROR Reading " + filePath + "  Message = " + e.getMessage());

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
