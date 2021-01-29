package com.geophy.steps;

import com.geophy.pom.LoginPage;
import com.geophy.pom.ReportPage;
import com.geophy.pom.SearchPage;
import com.geophy.utils.ConfigData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {

    LoginPage loginPage;
    SearchPage searchPage;
    ReportPage reportPage;
    private static final String WRONG_ADDRESS_ERROR = "Please input an address with a valid street number.";
    private static final String ADDRESS_SELECTION_ERROR = "Please select an address from the dropdown list that appears.";

    @Given("user is logged in to the app")
    public void userIsLoggedInToTheApp() {
        loginPage.open();
        loginPage.login(ConfigData.getValidUsername(), ConfigData.getValidPassword());
        assertThat(searchPage.isSearchAreaPresent()).isTrue();
    }

    @When("user enters the address in the search text field")
    public void userEntersTheAddressInTheSearchTextField() {
        searchPage.enterAddress(ConfigData.getValidSearchAddress());
    }

    @And("selects the address from the dropdown")
    public void selectsTheAddressFromTheDropdown() {
        searchPage.selectAddress();
    }

    @And("user clicks on run property")
    public void userClicksOnRunProperty() {
        searchPage.clickRunProperty();
    }

    @Then("user should see results for the address searched")
    public void userShouldSeeResultsForTheAddressSearched() {
        assertThat(reportPage.isSearchedAddressPresent()).isTrue();
    }

    @And("selects tab")
    public void selectsTab() {
        searchPage.selectTab();
    }

    @Then("user should get an error message to select address from the dropdown")
    public void userShouldGetAnErrorMessageToSelectAddressFromTheDropdown() {
        assertThat(searchPage.getErrorMessage()).isEqualTo(ADDRESS_SELECTION_ERROR);
    }

    @Then("user should get wrong address error message")
    public void userShouldGetWrongAddressErrorMessage() {
        assertThat(searchPage.getErrorMessage()).isEqualTo(WRONG_ADDRESS_ERROR);
    }

    @When("user enters invalid address in the search text field")
    public void userEntersInvalidAddressInTheSearchTextField() {
        searchPage.enterAddress(ConfigData.getInvalidSearchAddress());
    }

    @And("user clicks outside the text field")
    public void userClicksOutsideTheTextField() {
        searchPage.clickOnAddressIcon();
    }
}
