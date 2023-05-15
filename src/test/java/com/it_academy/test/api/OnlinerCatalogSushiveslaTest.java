package com.it_academy.test.api;

import com.it_academy.onliner.rest_api.service.SushiveslaService;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OnlinerCatalogSushiveslaTest {
    @Test
    public void verifySushiveslaProductsValuesNotNull() {
        AssertionsForClassTypes.assertThat(new SushiveslaService().getSushiveslaProducts()).hasNoNullFieldsOrProperties();
    }

    @Test
    public void verifyFilteredSushiveslaProducts() {
        assertThat(new SushiveslaService().getSushiveslaFilteredValues("name_prefix"))
                .containsOnly("Роллы");
    }
}