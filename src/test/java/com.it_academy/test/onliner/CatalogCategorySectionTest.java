package com.it_academy.test.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.HomePage;

import com.it_academy.test.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.open;

public class CatalogCategorySectionTest extends BaseTest {
    private HomePage homePage;
    private static final String MAIN_SECTION_TITLE = "Каталог";

    private static final String[] CATALOG_CATEGORY_SECTION_NAMES = {"Электроника", "Компьютеры и сети", "Бытовая техника",
            "На каждый день", "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам"};

    @BeforeClass
    @Description("Navigate to Onliner HomePage")
    public void init() {
        homePage = new HomePage();
        open(OnlinerUrls.HOME.getUrl());
    }

    @Test
    @Description("Verify that exact catalog category sections exist")
    public void verifyExactCatalogCategorySectionsExist() {
        homePage.clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .getCatalogCategorySections()
                .should(containExactTextsCaseSensitive(CATALOG_CATEGORY_SECTION_NAMES));
    }
}