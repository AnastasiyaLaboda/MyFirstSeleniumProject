package com.it_academy.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.rest_api.entity.SushiveslaProduct;

import java.util.List;
import java.util.Map;

import static com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints.getCatalogSushiveslaEndpoint;
import static com.it_academy.onliner.rest_api.utils.GetRequestUtils.makeRequestAndGetResponseBody;

public class SushiveslaService {
    public List<SushiveslaProduct> getSushiveslaProducts() {
        return makeRequestAndGetResponseBody(getCatalogSushiveslaEndpoint(), configureHeaders(), null)
                .jsonPath()
                .getList("products", SushiveslaProduct.class);
    }

    public List<String> getSushiveslaFilteredValues(String fieldName) {
        return makeRequestAndGetResponseBody(getCatalogSushiveslaEndpoint(), configureHeaders(), configureParams())
                .jsonPath()
                .getList("products." + fieldName);
    }

    public Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "www.onliner.by");
    }

    public Map<String, Object> configureParams() {
        return ImmutableMap.of("sushi_typ", "roll");
    }
}

/*    sushi_typ roll
    sushi_typ set
    sushi_typ salads
    sushi_typ desert
    sushi_typ souce
    sushi_typ garnier*/
