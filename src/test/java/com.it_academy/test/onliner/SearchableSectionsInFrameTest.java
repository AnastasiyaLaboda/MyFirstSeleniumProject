package com.it_academy.test.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.SearchPage;
import com.it_academy.test.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Selenide.open;

public class SearchableSectionsInFrameTest extends BaseTest {

    private SearchPage searchPage;
    private static final String[] SEARCHABLE_SECTIONS_NAMES = {"в каталоге", "в новостях", "на барахолке", "на форуме"};

    @BeforeClass
    @Description("Navigate to Onliner HomePage")
    public void init() {
        searchPage = new SearchPage();
        open(OnlinerUrls.HOME.getUrl());
   }

    @Test
    @Description("Verify exact searchable sections in search frame is exist")
    public void verifyExactSearchableSectionsInSearchFrameExist() {
        searchPage
                .writeSearchQuery("user's query")
                .switchToSearchFrame()
                .getSearchableSectionsInSearchFrame()
                .should(containExactTextsCaseSensitive(SEARCHABLE_SECTIONS_NAMES));
    }
}

