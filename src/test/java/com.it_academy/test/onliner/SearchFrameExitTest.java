package com.it_academy.test.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.SearchPage;
import com.it_academy.test.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchFrameExitTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeClass
    @Description("Navigate to Onliner HomePage")
    public void init() {
        searchPage = new SearchPage();
        open(OnlinerUrls.HOME.getUrl());
    }

    @Test
    @Description("Check that search frame disappears when click on close search button")
    public void checkSearchFrameDisappearsWhenClickOnCloseSearchButton() {
        searchPage
                .writeSearchQuery("user's query")
                .switchToSearchFrame()
                .clickOnCloseButtonInSearchFrame()
                .verifySearchFrameIsNotDisplayed();
    }
}

