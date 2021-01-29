package com.geophy.pom;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class ReportPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"report-navigation\"]/section[2]/div/div/div[1]/div")
    WebElementFacade ADDRESS;

    @FindBy(xpath = "//*[@id=\"report-content\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]")
    WebElementFacade OVERVIEW_NEIGHBORHOOD_RATING;

    @FindBy(xpath = "//*[@id=\"report-content\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]")
    WebElementFacade OVERVIEW_NEIGHBORHOOD_SCORE;

    @FindBy(xpath = "//*[@id=\"report-content\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]")
    WebElementFacade OVERVIEW_NEIGHBORHOOD_RANK;

    @FindBy(xpath = "//*[@id=\"property-neighborhood-panel\"]/div/div[1]/div[1]/div[2]")
    WebElementFacade NEIGHBORHOOD_RATING;

    @FindBy(xpath = "//*[@id=\"property-neighborhood-panel\"]/div/div[1]/div[2]/div[2]")
    WebElementFacade NEIGHBORHOOD_SCORE;

    @FindBy(xpath = "//*[@id=\"property-neighborhood-panel\"]/div/div[1]/div[3]/div[2]")
    WebElementFacade NEIGHBORHOOD_RANK;

    @FindBy(xpath = "//*[@id=\"report-content\"]/div/div[3]/div[2]/div[1]/div/div[1]/div[2]")
    WebElementFacade OVERVIEW_VALUATION_PROPERTY_VALUE;

    @FindBy(xpath = "//*[@id=\"report-content\"]/div/div[3]/div[2]/div[1]/div/div[2]/div[2]")
    WebElementFacade OVERVIEW_VALUATION_PROPERTY_VALUE_PER_UNIT;

    @FindBy(xpath = "//*[@id=\"report-content\"]/div/div[3]/div[2]/div[1]/div/div[3]/div[2]")
    WebElementFacade OVERVIEW_VALUATION_CAP_RATE;

    @FindBy(xpath = "//*[@id=\"transactionPrice\"]/div[1]/div")
    WebElementFacade VALUATION_PROPERTY_VALUE;

    @FindBy(xpath = "//*[@id=\"transactionPrice\"]/div[2]/div")
    WebElementFacade VALUATION_PROPERTY_VALUE_PER_UNIT;

    @FindBy(xpath = "//*[@id=\"transactionPrice\"]/div[3]/div")
    WebElementFacade VALUATION_CAP_RATE;

    @FindBy(xpath = "//*[@id=\"page-content\"]/div/div/div[2]/div[1]/div[1]/a[1]")
    WebElementFacade OVERVIEW_MENU;

    @FindBy(xpath = "//*[@id=\"page-content\"]/div/div/div[2]/div[1]/div[1]/a[2]")
    WebElementFacade NEIGHBORHOOD_MENU;

    @FindBy(xpath = "//*[@id=\"page-content\"]/div/div/div[2]/div[1]/div[1]/a[4]")
    WebElementFacade VALUATION_MENU;

    @FindBy(xpath = "//a[contains(text(),'Additional inputs required')]")
    WebElementFacade VALUATION_ADDITIONAL_INPUTS_LINK;

    @FindBy(xpath = "//input[@id='number_of_units']")
    WebElementFacade NUMBER_OF_UNITS;

    @FindBy(xpath = "//input[@id='year_built']")
    WebElementFacade YEAR_OF_CONSTRUCTION;

    @FindBy(xpath = "//input[@id='noi']")
    WebElementFacade NET_OPERATING_INCOME;

    @FindBy(xpath = "//button[contains(text(),'Run Module')]")
    WebElementFacade RUN_MODULES_BUTTON;

    @FindBy(xpath = "//*[@id=\"report-content\"]/div/div[2]/div")
    WebElementFacade VALUATION_DATA;

    public boolean isSearchedAddressPresent() {
        ADDRESS.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        return ADDRESS.isVisible();
    }

    public boolean isOverviewAndNeighborhoodDataMatch() {
        OVERVIEW_NEIGHBORHOOD_RATING.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        String overviewNeighborhoodRatingText = OVERVIEW_NEIGHBORHOOD_RATING.getText();
        String overviewNeighborhoodScoreText = OVERVIEW_NEIGHBORHOOD_SCORE.getText();
        String overviewNeighborhoodRankText = OVERVIEW_NEIGHBORHOOD_RANK.getText();
        selectNeighborhoodMenu();
        String neighborhoodRatingText = NEIGHBORHOOD_RATING.getText();
        String neighborhoodScoreText = NEIGHBORHOOD_SCORE.getText();
        String neighborhoodRankText = NEIGHBORHOOD_RANK.getText();

        if ((overviewNeighborhoodRatingText.equalsIgnoreCase(neighborhoodRatingText)) &&
                (overviewNeighborhoodScoreText.equalsIgnoreCase(neighborhoodScoreText)) &&
                (overviewNeighborhoodRankText.equalsIgnoreCase(neighborhoodRankText))) {
            return true;
        }
        return false;
    }

    public boolean isOverviewAndValuationDataMatch() {
        VALUATION_PROPERTY_VALUE.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        String valuationPropertyValueText = VALUATION_PROPERTY_VALUE.getText();
        String valuationPropertyValuePerUnitText = VALUATION_PROPERTY_VALUE_PER_UNIT.getText();
        String valuationCapRateText = VALUATION_CAP_RATE.getText();
        selectOverviewMenu();
        OVERVIEW_VALUATION_PROPERTY_VALUE.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        String overviewValuationPropertyValueText = OVERVIEW_VALUATION_PROPERTY_VALUE.getText();
        String overviewValuationPropertyValuePerUnitText = OVERVIEW_VALUATION_PROPERTY_VALUE_PER_UNIT.getText();
        String overviewValuationCapRateText = OVERVIEW_VALUATION_CAP_RATE.getText();

        if ((overviewValuationPropertyValueText.equalsIgnoreCase(valuationPropertyValueText)) &&
                (overviewValuationPropertyValuePerUnitText.equalsIgnoreCase(valuationPropertyValuePerUnitText)) &&
                (overviewValuationCapRateText.equalsIgnoreCase(valuationCapRateText))) {
            return true;
        }
        return false;
    }

    public void selectNeighborhoodMenu() {
        NEIGHBORHOOD_MENU.click();
    }

    public void selectValuationMenu() {
        VALUATION_MENU.click();
    }

    public void selectOverviewMenu() {
        OVERVIEW_MENU.click();
    }

    public void addAdditionalInputsForValuation() {
        VALUATION_ADDITIONAL_INPUTS_LINK.click();
        NUMBER_OF_UNITS.typeAndTab("200");
        YEAR_OF_CONSTRUCTION.typeAndTab("2000");
        NET_OPERATING_INCOME.type("2000000");
        RUN_MODULES_BUTTON.click();
    }

    public boolean isCalculatedEstimatePresent() {
        return VALUATION_DATA.isVisible();
    }
}
