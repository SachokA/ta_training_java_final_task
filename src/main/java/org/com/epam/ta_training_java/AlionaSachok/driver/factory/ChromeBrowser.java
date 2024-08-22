package org.com.epam.ta_training_java.AlionaSachok.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser extends BaseBrowser {

    private final boolean headless;

    public ChromeBrowser(boolean headless) {
        this.headless = headless;
    }

    @Override
    protected WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }

    @Override
    protected Class<?> getDriverClass() {
        return ChromeDriver.class;
    }
}