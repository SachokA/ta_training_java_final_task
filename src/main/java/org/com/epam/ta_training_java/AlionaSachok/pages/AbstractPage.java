package org.com.epam.ta_training_java.AlionaSachok.pages;

import org.com.epam.ta_training_java.AlionaSachok.driver.DriverUtils;
import org.com.epam.ta_training_java.AlionaSachok.driver.UrlUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = DriverUtils.getDriver();
        PageFactory.initElements(driver, this);}
}
