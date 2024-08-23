package org.com.epam.ta_training_java.AlionaSachok.driver.factory;

import org.openqa.selenium.WebDriver;
    public enum Browsers {
        DEFAULT_TEMPORARY(new ChromeBrowser(false)),
        FIREFOX_TEMPORARY(new FirefoxBrowser(false)),
        FIREFOX_WITHOUTUI(new FirefoxBrowser(true)),
        CHROME_TEMPORARY(new ChromeBrowser(false)),
        EDGE_TEMPORARY(new EdgeBrowser(false)),
        CHROME_WITHOUTUI(new ChromeBrowser(true));

        private final BaseBrowser browser;

        Browsers(BaseBrowser browser) {
            this.browser = browser;
        }

        public WebDriver runBrowser() {
            WebDriver driver = browser.getBrowser();
            driver.manage().window().maximize();
            return driver;
        }
    }

