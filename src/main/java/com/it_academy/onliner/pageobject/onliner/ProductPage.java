package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.pageobject.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.Selenide.*;
import static com.it_academy.onliner.constants.WaitTimeouts.EXPLICIT_WAIT;
import static java.time.Duration.ofSeconds;

public class ProductPage extends BasePage {
    private final By productLink = By.xpath("//div[@class='schema-product__group']");

    public enum ProductDetails {
        TITLE(By.xpath("//div[@class='schema-product__group']//span[contains(@data-bind, 'product.full_name')]")),
        DESCRIPTION(By.xpath("//div[@class='schema-product__group']//span[contains(@data-bind, 'product.description')]")),
        RATING(By.xpath("//div[@class='schema-product__group']//span[contains(@class, 'rating__fill')]")),
        PRICE(By.xpath("//div[@class='schema-product__group']//span[contains(@data-bind, 'prices')]")),
        IMAGINE(By.xpath("//div[@class='schema-product__group']//*[contains(@class, 'image-link')]")),
        CHECKBOX(By.xpath("//div[@class='schema-product__group']//label[contains(@class, 'control')]"));
        private By productDetailBy;

        public By getProductDetailBy() {
            return productDetailBy;
        }

        ProductDetails(By by) {
            this.productDetailBy = by;
        }
    }

    public ElementsCollection getProductsList() {
        return $$(productLink)
                .should(anyMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(EXPLICIT_WAIT));
    }

    public ElementsCollection getProductsDetailsList(ProductDetails productDetail) {
        return $$(productDetail.getProductDetailBy())
                .should(anyMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(EXPLICIT_WAIT));
    }
}
