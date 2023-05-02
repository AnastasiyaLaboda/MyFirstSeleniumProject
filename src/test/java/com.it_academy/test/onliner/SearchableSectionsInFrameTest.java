package com.it_academy.test.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.SearchPage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchableSectionsInFrameTest extends BaseTest {

    private SearchPage searchPage;
    private static final String[] SEARCHABLE_SECTIONS_NAMES = {"в каталоге", "в новостях", "на барахолке", "на форуме"};

    @BeforeClass
    public void init() {
        searchPage = new SearchPage();
        getWebDriver().get(OnlinerUrls.HOME.getUrl());
    }

    @Test
    public void verifyExactSearchableSectionsInSearchFrameExist() {
        searchPage
                .writeSearchQuery("user's query")
                .switchToSearchFrame()
                .getSearchableSectionsInSearchFrame()
                .should(containExactTextsCaseSensitive(SEARCHABLE_SECTIONS_NAMES));
    }
}

