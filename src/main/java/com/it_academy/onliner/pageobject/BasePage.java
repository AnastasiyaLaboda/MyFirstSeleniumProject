package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;

import static com.it_academy.onliner.constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {
    private final WebDriver driver;

    public BasePage() {
        driver = DriverManager.getWebDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(driver, ofSeconds(EXPLICIT_WAIT));
        return webDriverWait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(driver, ofSeconds(EXPLICIT_WAIT));
        webDriverWait.until(elementToBeClickable(by));
        return driver.findElement(by);
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> waitForExpectedElements(By by) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(driver, ofSeconds(EXPLICIT_WAIT));
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }
}
