package com.it_academy.onliner.framework.driver_creator;

import com.it_academy.onliner.framework.BrowserOptionsFactory;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static com.it_academy.onliner.constants.Config.GRID_HUB_URL;
import static com.it_academy.onliner.constants.Config.REMOTE_BROWSER;

public class RemoteDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    private static final Logger LOG = LoggerFactory.getLogger(RemoteDriverCreator.class);

    @Override
    public RemoteWebDriver create() {
        try {
            return new RemoteWebDriver(new URL(GRID_HUB_URL),
                    BrowserOptionsFactory.getBrowserOptions(REMOTE_BROWSER));
        } catch (MalformedURLException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
