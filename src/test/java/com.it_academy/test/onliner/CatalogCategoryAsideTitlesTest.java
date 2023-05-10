package com.it_academy.test.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.HomePage;
import com.it_academy.test.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Selenide.open;

public class CatalogCategoryAsideTitlesTest extends BaseTest {
    private HomePage homePage;
    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String CATALOG_CATEGORY = "Компьютеры";

    private static final String[] ASIDE_TITLES_NAMES = {"Ноутбуки, компьютеры, мониторы", "Комплектующие",
            "Техника для печати и дизайна", "Хранение данных", "Электропитание"};


    @BeforeClass
    @Description("Navigate to Onliner HomePage")
    public void init() {
        homePage = new HomePage();
        open(OnlinerUrls.HOME.getUrl());
      }

    @Test
    @Description("Verify that exact aside titles exist")
    public void verifyExactAsideTitlesOfCatalogCategorySectionExist() {
        homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY)
                .getCatalogCategorySectionAsideTitles()
                .should(containExactTextsCaseSensitive(ASIDE_TITLES_NAMES));
    }
}
