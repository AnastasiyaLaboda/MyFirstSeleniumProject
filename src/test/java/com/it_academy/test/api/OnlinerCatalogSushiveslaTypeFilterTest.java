package com.it_academy.test.api;

import com.it_academy.onliner.rest_api.service.SushiveslaService;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OnlinerCatalogSushiveslaTypeFilterTest {
    private static final String FIELD_NAME = "name_prefix";
    private static final String FILTER_TITLE = "sushi_typ";

    @Test(dataProvider = "sushiTypeTitles", dataProviderClass = ApiDataProviderClass.class)
    @Description("Check the filtered Sushivesla Type contains required value")
    public void verifyFilteredSushiveslaTypeFieldName(String selectedFilter, String selectedFilterValue) {
        assertThat(new SushiveslaService()
                .getSushiveslaFilteredValues(FIELD_NAME, FILTER_TITLE, selectedFilter))
                .contains(selectedFilterValue);
    }
}