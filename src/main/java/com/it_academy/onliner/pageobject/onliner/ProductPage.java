package com.it_academy.onliner.pageobject.onliner;

import com.it_academy.onliner.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class ProductPage extends BasePage {

    private final By productLink = By.xpath("//div[@class='schema-product__group']");
    private static final String PRODUCT_TITLE_LINK_XPATH_PATTERN =
            "//div[@class='schema-product__group'][%d]//span[contains(@data-bind, 'product.full_name')]";

    private static final String PRODUCT_DESCRIPTION_LINK_XPATH_PATTERN =
            "//div[@class='schema-product__group'][%d]//span[contains(@data-bind, 'product.description')]";
    private static final String PRODUCT_RATING_LINK_XPATH_PATTERN =
            "//div[@class='schema-product__group'][%d]//span[contains(@class, 'rating__fill')]";
    private static final String PRODUCT_PRICE_LINK_XPATH_PATTERN =
            "//div[@class='schema-product__group'][%d]//span[contains(@data-bind, 'prices')]";

    private static final String PRODUCT_IMG_LINK_XPATH_PATTERN =
            "//div[@class='schema-product__group'][%d]//*[contains(@class, 'image-link')]";

    private static final String PRODUCT_CHECKBOX_LINK_XPATH_PATTERN =
            "//div[@class='schema-product__group'][%d]//label[contains(@class, 'control')]";

    public List<WebElement> getProductList() {
        List<WebElement> productList = waitForExpectedElements(productLink);
        return new ArrayList<>(productList);
    }

    public boolean isProductTitleDisplayed(int item) {
        return isElementDisplayed(By.xpath(format(PRODUCT_TITLE_LINK_XPATH_PATTERN, item)));
    }

    public boolean isProductDescriptionDisplayed(int item) {
        return isElementDisplayed(By.xpath(format(PRODUCT_DESCRIPTION_LINK_XPATH_PATTERN, item)));
    }

    public boolean isProductRatingDisplayed(int item) {
        return isElementDisplayed(By.xpath(format(PRODUCT_RATING_LINK_XPATH_PATTERN, item)));
    }

    public boolean isProductPriceDisplayed(int item) {
        return isElementDisplayed(By.xpath(format(PRODUCT_PRICE_LINK_XPATH_PATTERN, item)));
    }

    public boolean isProductImageDisplayed(int item) {
        return isElementDisplayed(By.xpath(format(PRODUCT_IMG_LINK_XPATH_PATTERN, item)));
    }

    public boolean isProductCheckboxDisplayed(int item) {
        return isElementDisplayed(By.xpath(format(PRODUCT_CHECKBOX_LINK_XPATH_PATTERN, item)));
    }
}
