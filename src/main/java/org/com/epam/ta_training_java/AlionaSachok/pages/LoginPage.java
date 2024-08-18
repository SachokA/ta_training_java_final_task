package org.com.epam.ta_training_java.AlionaSachok.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

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
        userNameInput.sendKeys(name);
    }

    public void cleaUserNameInput() {
        userNameInput.click();
        userNameInput.sendKeys(Keys.CONTROL + "a");
        userNameInput.sendKeys(Keys.DELETE);
    }

    public void fillUserPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clearPassword() {
        passwordInput.click();
        passwordInput.sendKeys(Keys.CONTROL + "a");
        passwordInput.sendKeys(Keys.DELETE);
    }

    public void clickLoginButton() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getTitleLabel() {
        return titleLabel.getText();
    }
}
