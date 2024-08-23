package org.com.epam.ta_training_java.AlionaSachok.driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseBrowser implements Browser{
        protected abstract WebDriver createDriver();

        @Override
        public WebDriver getBrowser() {
            WebDriverManager.getInstance((Class<? extends WebDriver>) getDriverClass()).setup();
            return createDriver();
        }

        protected abstract Class<?> getDriverClass();
    }

