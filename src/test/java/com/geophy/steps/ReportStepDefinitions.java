package com.geophy.steps;

import com.geophy.pom.ReportPage;
import com.geophy.pom.SearchPage;
import com.geophy.utils.ConfigData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportStepDefinitions {
    SearchPage searchPage;
    ReportPage reportPage;

    @When("user search for a property")
    public void userSearchForAProperty() {
        searchPage.searchProperty(ConfigData.getValidSearchAddress());
    }

    @And("user is in the {string} page")
    public void userIsInThePage(String pageName) {
        if (pageName.equalsIgnoreCase("report")) {
            reportPage.isSearchedAddressPresent();
        }
    }

    @Then("user should see {string} details matching in overview and {string} menu")
    public void userShouldSeeMatchingInOverviewAndMenu(String menuName, String menuName1) {
        if (menuName.equalsIgnoreCase("neighborhood")) {
            assertThat(reportPage.isOverviewAndNeighborhoodDataMatch()).isTrue();
        } else if (menuName.equalsIgnoreCase("valuation")) {
            assertThat(reportPage.isOverviewAndValuationDataMatch()).isTrue();
        }
    }

    @And("submit {string} details")
    public void submitDetails(String input) {
        if (input.equalsIgnoreCase("valuation")) {
            reportPage.addAdditionalInputsForValuation();
        }
    }

    @Then("user should see calculated {string} estimate")
    public void userShouldSeeCalculatedEstimate(String input) {
        if (input.equalsIgnoreCase("valuation")) {
            assertThat(reportPage.isCalculatedEstimatePresent()).isTrue();
        }
    }
}
