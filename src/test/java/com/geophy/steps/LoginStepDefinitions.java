package com.geophy.steps;

import com.geophy.pom.LoginPage;
import com.geophy.pom.SearchPage;
import com.geophy.utils.ConfigData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinitions {
    LoginPage loginPage;
    SearchPage searchPage;
    private static final String LOGIN_ERROR = "There was an error with your e-mail or password, please try entering your login credentials again.";
    private static final String EMAIL_ERROR = "The email field is required.";
    private static final String PASSWORD_ERROR = "The password field is required.";

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.open();
        assertThat(loginPage.isLoginPageOpen()).isTrue();
    }

    @When("user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPage.login(ConfigData.getValidUsername(), ConfigData.getValidPassword());
    }

    @Then("user should be logged in to the app")
    public void userShouldBeLoggedInToTheApp() {
        assertThat(searchPage.isSearchAreaPresent()).isTrue();
    }

    @When("user logs in with invalid credentials")
    public void userLogsInWithInvalidCredentials() {
        loginPage.login(ConfigData.getInvalidUsername(), ConfigData.getInvalidPassword());
    }

    @Then("user should get error on login page")
    public void userShouldGetErrorOnLoginPage() {
        assertThat(loginPage.getErrorMessage()).isEqualTo(LOGIN_ERROR);
    }

    @When("user enters {string} and leaves {string} blank")
    public void userEntersAndLeavesBlank(String field1, String field2) {
        if (field1.equalsIgnoreCase("email")) {
            loginPage.login(ConfigData.getInvalidUsername(), "");
        } else {
            loginPage.login("", ConfigData.getInvalidPassword());
        }
    }

    @Then("user should see validation error for {string} field")
    public void userShouldSeeValidationErrorForField(String field1) {
        if (field1.equalsIgnoreCase("email")) {
            assertThat(loginPage.getEmailValidationError()).isEqualTo(EMAIL_ERROR);
        } else {
            assertThat(loginPage.getPasswordValidationError()).isEqualTo(PASSWORD_ERROR);
        }
    }

    @When("user leaves both email and password blank")
    public void userLeavesBothEmailAndPasswordBlank() {
        loginPage.login("", "");
    }

    @Then("user should see validation error for both the fields")
    public void userShouldSeeValidationErrorForBothTheFields() {
        assertThat(loginPage.getEmailValidationError()).isEqualTo(EMAIL_ERROR);
        assertThat(loginPage.getPasswordValidationError()).isEqualTo(PASSWORD_ERROR);
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
    }
}
