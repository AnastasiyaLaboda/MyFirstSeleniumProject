package com.it_academy.test.web.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.SearchPage;
import com.it_academy.test.web.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchFormInMainSectionsTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeClass
    @Description("Navigate to Onliner HomePage")
    public void init() {
        searchPage = new SearchPage();
        open(OnlinerUrls.HOME.getUrl());
    }

    @Test(dataProvider = "mainSectionTitles", dataProviderClass = DataProviderClass.class)
    @Description("Verify input search in section {title} exists")
    public void isInputSearchInEachMainSectionExists(String title) {
        searchPage
                .clickOnMainNavigationLink(title)
                .verifyInputSearchIsDisplayed();
    }
}
