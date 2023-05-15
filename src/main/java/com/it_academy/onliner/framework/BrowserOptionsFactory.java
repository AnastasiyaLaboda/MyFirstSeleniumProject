package com.it_academy.onliner.framework;

import org.openqa.selenium.remote.AbstractDriverOptions;

public class BrowserOptionsFactory {
    public static AbstractDriverOptions options;
    public static AbstractDriverOptions getBrowserOptions(String browserName) {
        return options = switch (browserName) {
            case "MicrosoftEdge" -> BrowserOptions.getEdgeOptions();
            case "gecko" -> BrowserOptions.getFirefoxOptions();
            default -> BrowserOptions.getChromeOptions();
        };
    }
}
