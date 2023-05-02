package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.DriverManager;

public abstract class BasePage {

    public BasePage() {
        DriverManager.initDriver();
    }
}
