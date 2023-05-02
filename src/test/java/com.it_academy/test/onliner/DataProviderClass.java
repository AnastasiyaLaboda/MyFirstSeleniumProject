package com.it_academy.test.onliner;

import com.it_academy.onliner.pageobject.onliner.ProductPage;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "mainSectionTitles")
    public static Object[][] provideMainSectionsTitles() {
        return new Object[][]{{"Каталог"}, {"Новости"}, {"Автобарахолка"},
                {"Дома и квартиры"}, {"Услуги"}, {"Барахолка"}, {"Форум"}};
    }

    @DataProvider(name = "productDetailsName")
    public static Object[][] provideProductDetailName() {
        ProductPage.ProductDetails[] productDetails = ProductPage.ProductDetails.values();
        Object[][] dataProvider = new Object[productDetails.length][1];
        for (int i = 0; i < productDetails.length; i++) {
            dataProvider[i][0] = productDetails[i];
        }
        return dataProvider;
    }
}