package org.com.epam.ta_training_java.AlionaSachok.driver.factory;

import org.openqa.selenium.WebDriver;
    public enum Browsers {
        DEFAULT_TEMPORARY(new ChromeTemporary()),
        FIREFOX_TEMPORARY(new FirefoxTemporary()),
        FIREFOX_WITHOUTUI(new FirefoxWithoutUI()),
        CHROME_TEMPORARY(new ChromeTemporary()),
        EDGE_TEMPORARY(new EdgeTemporary()),
        CHROME_WITHOUTUI(new ChromeWithoutUI());

        private Browser browser;

        private Browsers(Browser browser) {
            this.browser = browser;
        }

        public WebDriver runBrowser() {
            WebDriver driver = browser.getBrowser();
            driver.manage().window().maximize();
            return driver;
        }
    }

