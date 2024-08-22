package org.com.epam.ta_training_java.AlionaSachok.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser extends BaseBrowser {

    private final boolean headless;

    public FirefoxBrowser(boolean headless) {
        this.headless = headless;
    }

    @Override
    protected WebDriver createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }

    @Override
    protected Class<?> getDriverClass() {
        return FirefoxDriver.class;
    }
}