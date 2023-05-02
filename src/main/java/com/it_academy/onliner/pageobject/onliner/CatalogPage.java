package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.pageobject.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.it_academy.onliner.constants.WaitTimeouts.EXPLICIT_WAIT;
import static java.lang.String.*;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    private static final String CATALOG_CATEGORY_SECTION_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    private static final String CATALOG_CATEGORY_SECTION_CLASSIFIER_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and normalize-space(text())='%s']";

    private static final String PRODUCT_GROUP_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]"
                    + "//span[contains(@class, 'title') and contains(text(), '%s')]";
    private static final By productGroups =
            By.xpath("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]");
    private static final By catalogCategorySectionClassifiers =
            By.xpath("//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title')]");
    private static final By catalogCategorySections =
            By.xpath("//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]");

    public enum ProductGroupValues {
        /** Enum class for product group values */
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

    public CatalogPage clickOnCatalogCategorySectionLink(String link) {
        $x(format(CATALOG_CATEGORY_SECTION_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(EXPLICIT_WAIT))
                .click();
        return this;
    }

    public ElementsCollection getCatalogCategorySections() {
        return $$(catalogCategorySections)
                .should(anyMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(EXPLICIT_WAIT));
    }

    public ElementsCollection getCatalogCategorySectionAsideTitles() {
        return $$(catalogCategorySectionClassifiers)
                .should(anyMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(EXPLICIT_WAIT));
    }

    public CatalogPage clickOnCatalogCategorySectionClassifierLink(String link) {
        $x(format(CATALOG_CATEGORY_SECTION_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(and("clickable", visible, enabled), ofSeconds(EXPLICIT_WAIT))
                .click();
        return this;
    }

    public ElementsCollection getProductGroupsValues(ProductGroupValues groupValue) {
        return $$x(ProductGroupValues.valueOf(valueOf(groupValue)).getXPath())
                .should(anyMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(EXPLICIT_WAIT));
    }

    public ProductPage clickOnProductGroupLink(String productGroup) {
        $x(format(PRODUCT_GROUP_XPATH_PATTERN, productGroup))
                .shouldBe(visible, ofSeconds(EXPLICIT_WAIT))
                .click();
        return new ProductPage();
    }

    public ElementsCollection getProductGroups() {
        return $$(productGroups)
                .should(anyMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(EXPLICIT_WAIT));
    }
}