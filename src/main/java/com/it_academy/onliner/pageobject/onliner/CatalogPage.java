package com.it_academy.onliner.pageobject.onliner;

import com.it_academy.onliner.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.*;

public class CatalogPage extends BasePage {
    private static final String CATALOG_CATEGORY_SECTION_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";
    private static final String CATALOG_CATEGORY_SECTION_CLASSIFIER_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and normalize-space(text())='%s']";
    private static final String PRODUCT_GROUP_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]"
                    + "//span[contains(@class, 'title') and contains(text(), '%s')]";

    public enum ProductGroupValues {
        /**
         * Enum class for product group values
         */
        TITLE("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]//span[contains(@class, 'title')]"),
        NUMBER_OF_PRODUCTS_AND_MIN_PRICE("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]//span[contains(@class, 'description')]");

        private String xpath;

        ProductGroupValues(String xpath) {
            this.xpath = xpath;
        }

        public String getXPath() {
            return xpath;
        }
    }

    public boolean isCatalogCategorySectionTitlesDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(CATALOG_CATEGORY_SECTION_LINK_XPATH_PATTERN, title)));
    }

    public CatalogPage clickOnCatalogCategorySectionLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CATEGORY_SECTION_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public boolean isCatalogCategorySectionClassifierTitlesDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(CATALOG_CATEGORY_SECTION_CLASSIFIER_LINK_XPATH_PATTERN, title)));
    }

    public CatalogPage clickOnCatalogCategorySectionClassifierLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CATEGORY_SECTION_CLASSIFIER_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public List<WebElement> getProductGroupValuesList(String value) {
        List<WebElement> groupValueList = waitForExpectedElements(By.xpath(ProductGroupValues.valueOf(value).getXPath()));
        return new ArrayList<>(groupValueList);
    }

    public ProductPage clickOnProductGroupLink(String productGroup) {
        waitForElementVisible(By.xpath(format(PRODUCT_GROUP_XPATH_PATTERN, productGroup)))
                .click();
        return new ProductPage();
    }
}