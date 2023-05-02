package com.it_academy.test.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.HomePage;

import com.it_academy.onliner.pageobject.onliner.ProductPage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProductDetailsTest extends BaseTest {
    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String CATALOG_CATEGORY = "Электроника";
    private static final String CATALOG_CATEGORY_SECTION = "Аудиотехника";
    private static final String PRODUCT_GROUP = "Наушники";

    private static int PRODUCT_COUNT;

    @BeforeClass
    public void init() {
        HomePage homePage = new HomePage();
        getWebDriver().get(OnlinerUrls.HOME.getUrl());
        PRODUCT_COUNT = homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY)
                .clickOnCatalogCategorySectionClassifierLink(CATALOG_CATEGORY_SECTION)
                .clickOnProductGroupLink(PRODUCT_GROUP)
                .getProductsList()
                .size();
    }

    @Test(dataProvider = "productDetailsName", dataProviderClass = DataProviderClass.class)
    public void checkEachProductHasOwnDetailedInformation(ProductPage.ProductDetails name) {
        new ProductPage()
                .getProductsDetailsList(ProductPage.ProductDetails.valueOf(String.valueOf(name)))
                .shouldHave(sizeGreaterThanOrEqual(PRODUCT_COUNT));
    }
}