package com.it_academy.test.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner.framework.DriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeClass
    public void init() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
        DriverManager.initDriver();
    }

    @AfterClass
    public void closeBrowser() {
        closeWebDriver();
    }
}