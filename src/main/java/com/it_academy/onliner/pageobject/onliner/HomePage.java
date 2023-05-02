package com.it_academy.onliner.pageobject.onliner;

import com.it_academy.onliner.pageobject.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.it_academy.onliner.constants.WaitTimeouts.EXPLICIT_WAIT;
import static java.lang.String.*;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {

    protected static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'top-menu')]//*[contains(@class, 'main-navigation') and contains(text(), '%s')]";

    public void verifyMainNavigationSectionIsDisplayed(String title) {
        $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, title))
                .shouldBe(visible, ofSeconds(EXPLICIT_WAIT));
    }

    public CatalogPage clickOnMainNavigationLink(String link) {
        $x(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(EXPLICIT_WAIT))
                .click();
        return new CatalogPage();
    }
}
