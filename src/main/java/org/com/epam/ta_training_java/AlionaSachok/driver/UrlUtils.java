package org.com.epam.ta_training_java.AlionaSachok.driver;
import org.com.epam.ta_training_java.AlionaSachok.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UrlUtils {
    private static final String DEFAULT_URL = "https://www.saucedemo.com/";
    private static String baseUrl;
    private static final Logger logger = LoggerFactory.getLogger(UrlUtils.class);

    static {
        initUrl();
    }
    private UrlUtils() {
    }

    private static void initUrl() {
        try {
            baseUrl = PropertiesUtils.get().readBaseUrl();

            if (baseUrl == null || baseUrl.isEmpty() || baseUrl.equals(PropertiesUtils.ERROR_READ_PROPERTY)) {
                baseUrl = DEFAULT_URL;
                logger.warn("Base URL property is missing or invalid. Using default URL.");
            }
        } catch (Exception e) {
            logger.error("Failed to initialize base URL. Using default URL.", e);
            baseUrl = DEFAULT_URL;
        }
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}