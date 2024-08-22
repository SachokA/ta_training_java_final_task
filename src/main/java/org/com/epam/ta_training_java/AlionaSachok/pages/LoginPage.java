package org.com.epam.ta_training_java.AlionaSachok.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends AbstractPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    @FindBy(css = "#user-name")
    private WebElement userNameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(css = "#login-button")
    private WebElement submitButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;
    @FindBy(css = ".header_label .app_logo")
    private WebElement titleLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserNameInput(String name) {
        logger.info("Filling input name {}",name);
        userNameInput.sendKeys(name);
    }

    public void cleaUserNameInput() {
        logger.info("Click name input");
        userNameInput.click();
        logger.info("Cleaning all");
        userNameInput.sendKeys(Keys.CONTROL + "a");
        userNameInput.sendKeys(Keys.DELETE);
    }

    public void fillUserPasswordInput(String password) {
        logger.info("Filling input password {}",password);
        passwordInput.sendKeys(password);
    }

    public void clearPassword() {
        logger.info("Click password input");
        passwordInput.click();
        logger.info("Cleaning all");
        passwordInput.sendKeys(Keys.CONTROL + "a");
        passwordInput.sendKeys(Keys.DELETE);
    }

    public void clickLoginButton() {
        logger.debug("Login button have hitter");
        submitButton.click();
    }

    public String getErrorMessage() {
        logger.debug("Error message have received");
        return errorMessage.getText();
    }
    public String getTitleLabel() {
        return titleLabel.getText();
    }
}
