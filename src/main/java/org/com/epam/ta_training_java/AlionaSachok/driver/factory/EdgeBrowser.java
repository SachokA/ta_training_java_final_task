package org.com.epam.ta_training_java.AlionaSachok.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowser extends BaseBrowser {

    private final boolean headless;

    public EdgeBrowser(boolean headless) {
        this.headless = headless;
    }

    @Override
    protected WebDriver createDriver() {
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        return new EdgeDriver(options);
    }

    @Override
    protected Class<?> getDriverClass() {
        return EdgeDriver.class;
    }
}