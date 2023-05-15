package com.it_academy.onliner.rest_api.endpoints;

import com.it_academy.onliner.framework.PropertiesReader;

public class OnlinerEndpoints {
    public static String getCatalogSushiveslaEndpoint() {
        return PropertiesReader.getEndpointProperty("catalog.sushivesla");
    }
}
