package com.it_academy.test.onliner;

import com.it_academy.onliner.pageobject.onliner.CatalogPage;
import com.it_academy.onliner.pageobject.onliner.HomePage;
import com.it_academy.test.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.it_academy.onliner.constants.Constant.Urls.ONLINER_BY_HOME_PAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductGroupTest extends BaseTest {
    private HomePage homePage;

    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String CATALOG_CATEGORY = "Компьютеры";
    private static final String CATALOG_CATEGORY_SECTION = "Комплектующие";
    private static final String VALID_PRODUCTS_DESCRIPTION = "([\\d,]+)\\s*товар[а-я]*\\nот\\s([\\d,]+)\\sр\\s*";

    @BeforeClass
    public void navigationToHomePage() {
        homePage = new HomePage();
        homePage.open(ONLINER_BY_HOME_PAGE);
    }

    @Test
    public void eachProductGroupContains_Title_NumberOfProductsAndMinPrice_Test() {
        homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY)
                .clickOnCatalogCategorySectionClassifierLink(CATALOG_CATEGORY_SECTION);

        assertThat(new CatalogPage().getProductGroupValuesList(String.valueOf(CatalogPage.ProductGroupValues.TITLE)).size())
                .as("Product groups in " + CATALOG_CATEGORY_SECTION.toUpperCase() + " section does not have complete description")
                .isEqualTo(new CatalogPage().getProductGroupValuesList(String.valueOf(CatalogPage.ProductGroupValues.NUMBER_OF_PRODUCTS_AND_MIN_PRICE)).size());
    }

    @Test
    public void isInEachProductGroupNumberOfProductsAndMinPriceValid() {
        homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY)
                .clickOnCatalogCategorySectionClassifierLink(CATALOG_CATEGORY_SECTION);

        List<String> productGroupValuesList = new CatalogPage()
                .getProductGroupValuesList(String.valueOf(CatalogPage.ProductGroupValues.NUMBER_OF_PRODUCTS_AND_MIN_PRICE))
                .stream().map(WebElement::getText).collect(Collectors.toList());

        productGroupValuesList.forEach(element ->
                assertThat(element.matches(VALID_PRODUCTS_DESCRIPTION))
                        .isTrue());
    }
}