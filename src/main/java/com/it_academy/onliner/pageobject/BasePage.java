package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.DriverManager;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

    public BasePage() {
        DriverManager.initDriver();
    }

    public void exitFrame() {
        getWebDriver().switchTo().defaultContent();
    }
}
