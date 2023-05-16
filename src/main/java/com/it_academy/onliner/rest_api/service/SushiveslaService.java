package com.it_academy.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.rest_api.entity.SushiveslaProduct;
import io.qameta.allure.Step;

import java.util.List;
import java.util.Map;

import static com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints.getCatalogSushiveslaEndpoint;
import static com.it_academy.onliner.rest_api.utils.GetRequestUtils.makeRequestAndGetResponseBody;

public class SushiveslaService {

    @Step("Get Sushivesla Products list")
    public List<SushiveslaProduct> getSushiveslaProducts() {
        return makeRequestAndGetResponseBody(getCatalogSushiveslaEndpoint(), configureHeaders(), null)
                .jsonPath()
                .getList("products", SushiveslaProduct.class);
    }

    @Step("Get filtered {filterKey} by {selectedFilter} Sushivesla Products {fieldName}")
    public List<String> getSushiveslaFilteredValues(String fieldName, String filterKey, String selectedFilter) {
        return makeRequestAndGetResponseBody(
                getCatalogSushiveslaEndpoint(), configureHeaders(), configureParams(filterKey, selectedFilter))
                .jsonPath()
                .getList("products." + fieldName);
    }

    public Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "www.onliner.by");
    }

    public Map<String, Object> configureParams(String filterKey, String selectedFilter) {
        return ImmutableMap.of(filterKey, selectedFilter);
    }
}