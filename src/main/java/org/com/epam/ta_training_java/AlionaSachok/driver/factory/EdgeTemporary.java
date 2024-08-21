package org.com.epam.ta_training_java.AlionaSachok.driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

class EdgeTemporary implements Browser {
    public WebDriver getBrowser() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}