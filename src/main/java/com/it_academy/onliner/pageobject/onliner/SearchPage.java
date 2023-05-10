package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.onliner.pageobject.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.it_academy.onliner.constants.WaitTimeouts.EXPLICIT_WAIT;

import static com.it_academy.onliner.pageobject.onliner.HomePage.MAIN_NAVIGATION_LINK_XPATH_PATTERN;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class SearchPage extends BasePage {
    private static final SelenideElement searchForm =
            $x("//div[contains(@class, 'b-top')]//input[contains(@class, 'fast-search')]");
    private static final SelenideElement searchFrame =
            $x("//div[@class='modal-content']//iframe[@class='modal-iframe']");
    private static final SelenideElement closeButtonInSearchFrame =
            $x("//span[contains(@class, 'close')]");
    private static final String SEARCHABLE_SECTIONS_IN_FRAME_LINK =
            "//div[@class='search__tabs']//div[contains(@class, 'search__tabs-item')]";

    @Step("Click on main navigation link {link}")
    public SearchPage clickOnMainNavigationLink(String link) {
        $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(EXPLICIT_WAIT))
                .click();
        return this;
    }

    @Step("Verify input search is displayed")
    public void verifyInputSearchIsDisplayed() {
        searchForm.shouldBe(visible, ofSeconds(EXPLICIT_WAIT));
    }

    @Step("Write {searchQuery} in Search Form")
    public SearchPage writeSearchQuery(String searchQuery) {
        searchForm.click();
        searchForm.sendKeys(searchQuery);
        return this;
    }

    @Step("Switch to the Search Frame")
    public SearchPage switchToSearchFrame() {
        getWebDriver().switchTo().frame(searchFrame);
        return this;
    }

    @Step("Verify Search Frame is not displayed")
    public void verifySearchFrameIsNotDisplayed() {
        searchFrame.shouldNotBe(visible, ofSeconds(EXPLICIT_WAIT));
    }

    @Step("Get searchable sections in search frame")
    public ElementsCollection getSearchableSectionsInSearchFrame() {
        return $$x(SEARCHABLE_SECTIONS_IN_FRAME_LINK)
                .should(allMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(EXPLICIT_WAIT));
    }

    @Step("Click on close button in Search Frame")
    public SearchPage clickOnCloseButtonInSearchFrame() {
        closeButtonInSearchFrame.click();
        return this;
    }
}
