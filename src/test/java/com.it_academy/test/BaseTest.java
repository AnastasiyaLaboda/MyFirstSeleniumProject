package com.it_academy.test;

import com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import static com.it_academy.onliner.constants.Constant.Urls.ONLINER_BY_HOME_PAGE;

public class BaseTest {

    @BeforeClass
    public void navigationToHomePage() {
        DriverManager.getWebDriver();
    }

    @AfterClass
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }
}

