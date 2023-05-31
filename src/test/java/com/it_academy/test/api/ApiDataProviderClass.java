package com.it_academy.test.api;

import org.testng.annotations.DataProvider;

public class ApiDataProviderClass {
    @DataProvider(name = "sushiTypeTitles")
    public static Object[][] provideSushiType() {
        return new Object[][]{{"roll", "Роллы"}, {"set", "Сет"}, {"souce", "Соус"}};
    }
}
