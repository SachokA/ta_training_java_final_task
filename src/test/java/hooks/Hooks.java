package hooks;

import io.cucumber.java.*;
import org.com.epam.ta_training_java.AlionaSachok.driver.DriverUtils;
import org.com.epam.ta_training_java.AlionaSachok.driver.UrlUtils;
import org.com.epam.ta_training_java.AlionaSachok.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    private static WebDriver driver;


    @BeforeAll
    public static void setUp() {
        logger.info("Opening driver...");
        driver = DriverUtils.getDriver();

    }

    @After
    public void makeScreenWhenFail(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            DriverUtils.takeScreenshot(screenshotName);
            logger.info("Screenshot taken for failed scenario: {}", screenshotName);
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            logger.info("Closing WebDriver...");
            DriverUtils.quit();
            logger.info("WebDriver closed.");
        }
    }

    public static LoginPage loadApplication() {
        DriverUtils.getUrl(UrlUtils.getBaseUrl());
        return new LoginPage(driver);
    }

}
