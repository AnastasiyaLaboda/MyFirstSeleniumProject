package com.it_academy.test.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.HomePage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainSectionsOnHomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void navigateToHomePage() {
        homePage = new HomePage();
        getWebDriver().get(OnlinerUrls.HOME.getUrl());
    }

    @Test(dataProvider = "mainSectionTitles", dataProviderClass = DataProviderClass.class)
    public void checkIfMainSectionsOnHomePageExist(String title) {
        homePage.verifyMainNavigationSectionIsDisplayed(title);
    }
}
