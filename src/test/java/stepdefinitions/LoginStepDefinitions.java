package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.com.epam.ta_training_java.AlionaSachok.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(LoginStepDefinitions.class);
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        logger.info("Opening home page");
        loginPage = Hooks.loadApplication();
        logger.debug("Login page has been opened successfully");
    }

    @When("I hit the 'Login' button")
    public void iHitTheButton() {
        logger.info("Pressing button 'Login'");
        loginPage.clickLoginButton();
        logger.debug("Login button has been pressed successfully");
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        logger.info("Checking that error message is the same as '{}'", expectedMessage);
        String actualMessage = loginPage.getErrorMessage();
        logger.debug("Error message was received");
        assertThat(actualMessage)
                .isEqualTo(expectedMessage).as("Actual error message 's%', but should be 's%' ",
                        actualMessage, expectedMessage);
    }

    @And("I clear the Password input")
    public void iClearThePasswordInput() {
        logger.info("Clearing input 'Password'");
        loginPage.clearPassword();
        logger.debug("Input password have been cleaned");
    }

    @Then("I should see the title {string} on the dashboard")
    public void iShouldSeeTheTitleSwagLabsOnTheDashboard(String title) {
        logger.info("Checking that title is the same as '{}'", title);
        String actualTitle = loginPage.getTitleLabel();
        assertThat(actualTitle)
                .isEqualTo(title)
                .as("Expected title to be '%s', but was '%s'",
                        actualTitle, title);
    }

    @When("I enter the user name {string} field")
    public void iEnterTheUsernameField(String name) {
        logger.info("Filling input 'Name'");
        loginPage.fillUserNameInput(name);
        logger.debug("Input name was filled {}", name);
    }

    @When("I enter the password {string}")
    public void iEnterPassword(String password) {
        logger.info("Filling input 'Password'");
        loginPage.fillUserPasswordInput(password);
        logger.debug("Input Password was filled {} ", password);
    }

    @And("I clear the Name input")
    public void iClearTheNameInput() {
        logger.info("Clearing input 'Name'");
        loginPage.cleaUserNameInput();
        logger.debug("Input name was filled ");
    }
}


