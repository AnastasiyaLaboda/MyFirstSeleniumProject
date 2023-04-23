package com.it_academy.test.onliner;

import com.it_academy.onliner.pageobject.onliner.CatalogPage;
import com.it_academy.onliner.pageobject.onliner.HomePage;

import com.it_academy.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.it_academy.onliner.constants.Constant.Urls.ONLINER_BY_HOME_PAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogCategorySectionTest extends BaseTest {
    private final HomePage homePage = new HomePage();
    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String CATALOG_CATEGORY = "Компьютеры";

    @BeforeClass
    public void navigationToHomePage() {
        homePage.open(ONLINER_BY_HOME_PAGE);
    }

    @DataProvider(name = "catalogCategorySectionTitles")
    public Object[][] provideCatalogCategorySectionTitles() {
        return new Object[][]{{"Электроника"}, {"Компьютеры и\u00a0сети"}, {"Бытовая техника"}, {"На каждый день"},
                {"Стройка и\u00a0ремонт"}, {"Дом и\u00a0сад"}, {"Авто и\u00a0мото"}, {"Красота и\u00a0спорт"}, {"Детям и\u00a0мамам"}};
    }

    @Test(dataProvider = "catalogCategorySectionTitles")
    public void testIsCatalogCategoryClassifierTitlesExists(String catalogCategorySectionTitle) {
        homePage.clickOnMainNavigationLink(MAIN_SECTION_TITLE);
        assertThat(new CatalogPage().isCatalogCategorySectionTitlesDisplayed(catalogCategorySectionTitle))
                .as("Catalog category section " + catalogCategorySectionTitle.toUpperCase() + " is not displayed")
                .isTrue();
    }

    @DataProvider(name = "catalogCategorySectionClassifierTitles")
    public Object[][] provideMainSectionsTitles() {
        return new Object[][]{{"Ноутбуки, компьютеры, мониторы"}, {"Комплектующие"},
                {"Техника для\u00a0печати и\u00a0дизайна"}, {"Хранение данных"}, {"Электропитание"}};
    }

    @Test(dataProvider = "catalogCategorySectionClassifierTitles")
    public void testIsAsideListOfCategorySectionExists(String asideTitle) {
        homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY);
        assertThat(new CatalogPage().isCatalogCategorySectionClassifierTitlesDisplayed(asideTitle))
                .as("In category \"" + CATALOG_CATEGORY + "\" aside title \"" + asideTitle + "\" is not displayed")
                .isTrue();
    }
}
