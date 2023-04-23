package com.it_academy.test.onliner;

import com.it_academy.onliner.pageobject.onliner.HomePage;
import com.it_academy.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.it_academy.onliner.constants.Constant.Urls.ONLINER_BY_HOME_PAGE;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MainSectionsOnHomePageTest extends BaseTest {
    private final HomePage homePage = new HomePage();

    @BeforeClass
    public void navigationToHomePage() {
        homePage.open(ONLINER_BY_HOME_PAGE);
    }

    @DataProvider(name = "mainSectionsTitles")
    public Object[][] provideMainSectionsTitles() {
        return new Object[][]{{"Каталог"}, {"Новости"}, {"Автобарахолка"},
                {"Дома и квартиры"}, {"Услуги"}, {"Барахолка"}, {"Форум"}};
    }

    @Test(dataProvider = "mainSectionsTitles")
    public void testIsMainSectionsOnHomePageExists(String title) {
        assertThat(homePage.isMainNavigationSectionDisplayed(title))
                .as("Main navigation section " + title.toUpperCase() + " is not displayed")
                .isTrue();
    }
}
