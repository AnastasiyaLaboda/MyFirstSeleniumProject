package com.it_academy.onliner.framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.it_academy.onliner.constants.WaitTimeouts.IMPLICIT_WAIT;

public class DriverManager {

    public synchronized static void initDriver() {
        Configuration.browser = DriverProvider.class.getName();
        Configuration.pageLoadTimeout = IMPLICIT_WAIT;
        open();
        getWebDriver().manage().window().maximize();
    }
}