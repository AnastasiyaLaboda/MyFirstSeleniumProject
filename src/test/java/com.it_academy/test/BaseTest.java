package com.it_academy.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner.framework.DriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void init() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
        DriverManager.initDriver();
    }
}