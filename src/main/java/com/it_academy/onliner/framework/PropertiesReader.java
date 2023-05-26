package com.it_academy.onliner.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);
    private static final String ENDPOINTS_FILE = "/endpoints.properties";
    private static final Properties ENDPOINTS_PROPERTIES = new Properties();

    static {
        initProperties(ENDPOINTS_PROPERTIES, ENDPOINTS_FILE);
    }

    public static String getEndpointProperty(String property) {
        return ENDPOINTS_PROPERTIES.getProperty(property);
    }

    private static synchronized void initProperties(Properties properties, String fileName) {
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new IllegalArgumentException("Unable to load properties from file: " + fileName);
        }
    }
}
