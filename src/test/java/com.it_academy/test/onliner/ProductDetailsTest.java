package com.it_academy.test.onliner;

import com.it_academy.onliner.pageobject.onliner.HomePage;

import com.it_academy.onliner.pageobject.onliner.ProductPage;
import com.it_academy.test.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.it_academy.onliner.constants.Constant.Urls.ONLINER_BY_HOME_PAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductDetailsTest extends BaseTest {

    private final HomePage homePage = new HomePage();

    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String CATALOG_CATEGORY = "Электроника";
    private static final String CATALOG_CATEGORY_SECTION = "Аудиотехника";
    private static final String PRODUCT_GROUP = "Наушники";
    private List<WebElement> productList;

    @BeforeClass
    public void navigationToHomePage() {
        homePage.open(ONLINER_BY_HOME_PAGE);
        homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY)
                .clickOnCatalogCategorySectionClassifierLink(CATALOG_CATEGORY_SECTION)
                .clickOnProductGroupLink(PRODUCT_GROUP);
        productList = new ProductPage().getProductList();
    }

    @Test
    public void testIsProductTitleExists() {
        for (int i = 0; i < productList.size(); i++) {
            assertThat(new ProductPage().isProductTitleDisplayed(i + 1))
                    .as("Title of Product " + (i + 1) + " is not displayed")
                    .isTrue();
        }
    }

    @Test
    public void testIsProductDescriptionExists() {
        for (int i = 0; i < productList.size(); i++) {
            assertThat(new ProductPage().isProductDescriptionDisplayed(i + 1))
                    .as("Description of Product " + (i + 1) + " is not displayed")
                    .isTrue();
        }
    }

    @Test
    public void testIsProductRatingExists() {
        for (int i = 0; i < productList.size(); i++) {
            assertThat(new ProductPage().isProductRatingDisplayed(i + 1))
                    .as("Rating of Product " + (i + 1) + " is not displayed")
                    .isTrue();
        }
    }

    @Test
    public void testIsProductPriceExists() {
        for (int i = 0; i < productList.size(); i++) {
            assertThat(new ProductPage().isProductPriceDisplayed(i + 1))
                    .as("Price of Product " + (i + 1) + " is not displayed")
                    .isTrue();
        }
    }

    @Test
    public void testIsProductImgExists() {
        for (int i = 0; i < productList.size(); i++) {
            assertThat(new ProductPage().isProductImageDisplayed(i + 1))
                    .as("Images of Product " + (i + 1) + " are not displayed")
                    .isTrue();
        }
    }

    @Test
    public void testIsProductCheckboxExists() {
        for (int i = 0; i < productList.size(); i++) {
            assertThat(new ProductPage().isProductCheckboxDisplayed(i + 1))
                    .as("Checkboxes of Product " + (i + 1) + " are not displayed")
                    .isTrue();
        }
    }
}
