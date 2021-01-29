package com.geophy.pom;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@id='email']")
    private WebElementFacade EMAIL;

    @FindBy(xpath = "//span[contains(text(),'The email field is required.')]")
    WebElementFacade EMAIL_ERROR;

    @FindBy(xpath = "//input[@id='password']")
    WebElementFacade PASSWORD;

    @FindBy(xpath = "//span[contains(text(),'The password field is required.')]")
    WebElementFacade PASSWORD_ERROR;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElementFacade LOGIN_BUTTON;

    @FindBy(xpath = "//body/div[@id='app']/section[1]/section[1]/div[1]/div[2]/div[1]/div[1]")
    WebElementFacade ERROR_MESSAGE;

    public SearchPage login(String email, String password) {
        EMAIL.typeAndTab(email);
        PASSWORD.typeAndTab(password);
        clickOnLoginButton();
        return getPages().currentPageAt(SearchPage.class);
    }

    public boolean isLoginPageOpen() {
        EMAIL.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        return EMAIL.isVisible();
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE.getText();
    }

    public String getEmailValidationError() {
        return EMAIL_ERROR.getText();
    }

    public String getPasswordValidationError() {
        return PASSWORD_ERROR.getText();
    }

    public void clickOnLoginButton() {
        LOGIN_BUTTON.click();
    }
}
