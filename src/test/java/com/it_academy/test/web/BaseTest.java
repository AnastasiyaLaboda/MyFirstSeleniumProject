package com.it_academy.test.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner.constants.Config;
import com.it_academy.onliner.framework.DriverManager;
import com.it_academy.onliner.framework.driver_creator.RemoteDriverCreator;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(RemoteDriverCreator.class);

    @BeforeClass
    @Parameters(value = {"browser"})
    public synchronized void init(@Optional String browser) {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));

        if (browser != null) {
            Config.BROWSER_TO_OPEN = browser;
            DriverManager.initDriver();
        } else {
            LOG.info("DriverType from Configuration");
            DriverManager.initDriver();
        }
    }

    @AfterClass
    public synchronized void closeBrowser() {
        closeWebDriver();
    }
}