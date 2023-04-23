package com.it_academy.onliner.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.it_academy.onliner.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class DriverManager {
    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    private static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");

        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver() {
        if (driver.get() == null) {
            setWebDriver();
        }
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().close();
        driver.remove();
    }
}