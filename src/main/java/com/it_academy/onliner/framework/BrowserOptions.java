package com.it_academy.onliner.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName(Platform.WIN10.name());
        options.setCapability("browserName", "chrome");
        return options;
    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setPlatformName(Platform.WIN10.name());
        options.setCapability("browserName", "MicrosoftEdge");
        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPlatformName(Platform.WIN10.name());
        options.setCapability("browserName", "firefox");
        return options;
    }
}
