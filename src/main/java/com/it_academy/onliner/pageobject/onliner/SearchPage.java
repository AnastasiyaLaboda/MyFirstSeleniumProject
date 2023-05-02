package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.onliner.pageobject.BasePage;

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

    public SearchPage clickOnMainNavigationLink(String link) {
        $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(EXPLICIT_WAIT))
                .click();
        return this;
    }

    public void verifyInputSearchIsDisplayed() {
        searchForm.shouldBe(visible, ofSeconds(EXPLICIT_WAIT));
    }

    public SearchPage writeSearchQuery(String searchQuery) {
        searchForm.click();
        searchForm.sendKeys(searchQuery);
        return this;
    }

    public SearchPage switchToSearchFrame() {
        getWebDriver().switchTo().frame(searchFrame);
        return this;
    }

    public void verifySearchFrameIsNotDisplayed() {
        searchFrame.shouldNotBe(visible, ofSeconds(EXPLICIT_WAIT));
    }

    public ElementsCollection getSearchableSectionsInSearchFrame() {
        return $$x(SEARCHABLE_SECTIONS_IN_FRAME_LINK)
                .should(allMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(EXPLICIT_WAIT));
    }

    public SearchPage clickOnCloseButtonInSearchFrame() {
        closeButtonInSearchFrame.click();
        return this;
    }

    public void exitFrame() {
        getWebDriver().switchTo().defaultContent();
    }
}
