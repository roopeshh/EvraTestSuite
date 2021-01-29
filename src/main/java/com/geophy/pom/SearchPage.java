package com.geophy.pom;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class SearchPage extends PageObject {

    @FindBy(xpath = "//body/div[@id='app']/section[1]/section[1]/div[2]/div[1]/div[1]")
    WebElementFacade SEARCH_AREA;

    @FindBy(xpath = "//label[contains(text(),'Address')]")
    WebElementFacade ADDRESS_LABEL;

    @FindBy(xpath = "//*[@id=\"valuation-form\"]/div[1]/div[1]/div/div/i[1]")
    WebElementFacade ADDRESS_ICON;

    @FindBy(xpath = "//input[@id='address_input']")
    WebElementFacade ADDRESS_INPUT;

    @FindBy(xpath = "//button[contains(text(),'Run Property')]")
    WebElementFacade RUN_PROPERTY_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'View sample report')]")
    WebElementFacade VIEW_SAMPLE_REPORT_LINK;

    @FindBy(xpath = "//body/div[2]")
    List<WebElementFacade> ADDRESS_LIST;

    @FindBy(xpath = "//*[@id=\"valuation-form\"]/div[1]/div[2]/span")
    WebElementFacade ERROR_MESSAGE;

    public boolean isSearchAreaPresent() {
        SEARCH_AREA.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
        return SEARCH_AREA.isVisible();
    }

    public void enterAddress(String address) {
        ADDRESS_INPUT.type(address);
    }

    public void selectAddress() {
        for (WebElementFacade option : ADDRESS_LIST) {
            option.click();
        }
    }

    public void selectTab() {
        ADDRESS_INPUT.type(Keys.TAB);
    }

    public void clickRunProperty() {
        RUN_PROPERTY_BUTTON.click();
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE.getText();
    }

    public ReportPage searchProperty(String address) {
        enterAddress(address);
        selectAddress();
        RUN_PROPERTY_BUTTON.click();
        return getPages().currentPageAt(ReportPage.class);
    }

    public void clickOnAddressIcon() {
        ADDRESS_ICON.click();
    }
}
