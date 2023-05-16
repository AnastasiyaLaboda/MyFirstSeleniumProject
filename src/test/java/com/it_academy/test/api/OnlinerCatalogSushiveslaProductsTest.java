package com.it_academy.test.api;

import com.it_academy.onliner.rest_api.service.SushiveslaService;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnlinerCatalogSushiveslaProductsTest {
    @Test
    @Description("Verify each Sushivesla Product contains no null the fields")
    public void verifySushiveslaProductsFieldsNotNull() {
        assertThat(new SushiveslaService().getSushiveslaProducts()).hasNoNullFieldsOrProperties();
    }
}