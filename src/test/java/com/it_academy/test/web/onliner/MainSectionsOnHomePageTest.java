package com.it_academy.test.web.onliner;

import com.it_academy.onliner.constants.OnlinerUrls;
import com.it_academy.onliner.pageobject.onliner.HomePage;
import com.it_academy.test.web.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class MainSectionsOnHomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    @Description("Navigate to Onliner HomePage")
    public void navigateToHomePage() {
        homePage = new HomePage();
        open(OnlinerUrls.HOME.getUrl());
    }

    @Test(dataProvider = "mainSectionTitles", dataProviderClass = DataProviderClass.class)
    @Description("Verify main sections on HomePage are exist")
    public void checkIfMainSectionsOnHomePageExist(String title) {
        homePage.verifyMainNavigationSectionIsDisplayed(title);
    }
}
