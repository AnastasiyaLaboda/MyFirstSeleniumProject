package com.it_academy.onliner.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import static com.it_academy.onliner.constants.Config.BROWSER_TO_OPEN;

public class DriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        return Driver.getByDriverType(BROWSER_TO_OPEN).getWebDriverCreator().create();
    }
}
