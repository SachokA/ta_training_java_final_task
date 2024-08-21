package org.com.epam.ta_training_java.AlionaSachok.driver;


import org.apache.commons.io.FileUtils;
import org.com.epam.ta_training_java.AlionaSachok.driver.factory.Browsers;
import org.com.epam.ta_training_java.AlionaSachok.utils.PropertiesUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public final class DriverUtils {
    private static final Logger logger = LoggerFactory.getLogger(DriverUtils.class);
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private static Map<Long, WebDriver> drivers = new HashMap<>();
    private static Browsers defaultBrowser;

    static {
        initDriver();
    }

    private DriverUtils() {
        initDriver();
    }

    private static void initDriver() {
        String browserName = PropertiesUtils.get().readBrowserName();
        if (browserName.equals(PropertiesUtils.ERROR_READ_PROPERTY)) {
            defaultBrowser = Browsers.DEFAULT_TEMPORARY;
        } else {
            defaultBrowser = getBrowserByPartialName(browserName);
        }
    }

    private static Browsers getBrowserByPartialName(String browserName) {
        Browsers browser = Browsers.DEFAULT_TEMPORARY;
        browserName = browserName.toLowerCase()
                .replaceAll("[_-]", " ")
                .replaceAll("[ ]+", " ")
                .trim();
        for (Browsers current : Browsers.values()) {
            String currentName = current.name().toLowerCase().replace("_", " ");
            if (currentName.contains(browserName)) {
                browser = current;
                break;
            }
        }
        return browser;
    }

    public static WebDriver addDriverByPartialName(String browserName) {
        return addDriver(getBrowserByPartialName(browserName));
    }

    public static WebDriver addDriver(Browsers browser) {
        drivers.put(Thread.currentThread().getId(), browser.runBrowser());
        return drivers.get(Thread.currentThread().getId());
    }
    
    public static WebDriver getDriver() {
        WebDriver driver = drivers.get(Thread.currentThread().getId());
        //
        if (driver == null) {
            driver = addDriver(defaultBrowser);
        }
        return driver;
    }

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }

    public static void navigateToUrl(String url) {
        getDriver().navigate().to(url);
    }

    public static void getUrl(String url) {
        getDriver().get(url);
    }

    public static void takeScreenshot(String fileName) {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_TEMPLATE);
        String timestamp = localDate.format(formatter);
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File destination = new File("target/screenshots/" + fileName + "_" + timestamp + ".png");
        try {
            Files.createDirectories(destination.getParentFile().toPath());
            FileUtils.copyFile(scrFile, destination);
        } catch (IOException e) {
            logger.error("Failed to create screenshot at: {}. Message: {}",
                    destination.getPath() ,e.getMessage());
        }
    }
    public static void quit() {
        logger.info("Closing driver");
        for (Map.Entry<Long, WebDriver> driverEntry : drivers.entrySet()) {
            if (driverEntry.getValue() != null) {
                try {
                    driverEntry.getValue().quit();
                } catch (Exception e) {
                    logger.error("Failed to quit WebDriver for thread ID: {}. Message: {}",
                            driverEntry.getKey(), e.getMessage());
                }
            }
        }
    }
}
