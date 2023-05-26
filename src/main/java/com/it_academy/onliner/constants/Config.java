package com.it_academy.onliner.constants;

public class Config {
    public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\browsers\\chromedriver.exe";
    public static final String EDGE_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\browsers\\msedgedriver.exe";
    public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\browsers\\geckodriver.exe";

    public static String BROWSER_TO_OPEN = "chrome";
    public static final String GRID_HUB_URL = "http://192.168.36.2:4444/";
    public static final String REMOTE_BROWSER = System.getProperty("remoteBrowser");
}
