package com.it_academy.test.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.SearchPage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchFormInMainSectionsTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeClass
    public void init() {
        searchPage = new SearchPage();
        getWebDriver().get(OnlinerUrls.HOME.getUrl());
    }

    @Test(dataProvider = "mainSectionTitles", dataProviderClass = DataProviderClass.class)
    public void isInputSearchInEachMainSectionExists(String title) {
        searchPage
                .clickOnMainNavigationLink(title)
                .verifyInputSearchIsDisplayed();
    }
}
