package com.automate.factories;

import com.automate.constants.FrameworkConstants;
import com.automate.driver.DriverManager;
import com.automate.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public  class WaitFactory {

    protected WebDriverWait wait;
    private static int defaultTimeOutInSecond = 30;

    public static WebElement explicitlyWaitForElementLocatedBy(WaitStrategy waitStrategy, By by) {
        WebElement webElement = null;
        switch (waitStrategy) {
            case CLICKABLE:
                webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.elementToBeClickable(by));
                break;
            case PRESENCE:
                webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.presenceOfElementLocated(by));
                break;
            case VISIBLE:
                webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
                break;
            case NONE:
                webElement = DriverManager.getDriver().findElement(by);
                break;
        }
        return webElement;
    }


    public static WebElement explicitlyWaitForElement(WaitStrategy waitStrategy, By by) {
        WebElement element = null;
        switch (waitStrategy) {
            case CLICKABLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.elementToBeClickable(by));
                break;
            case PRESENCE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.presenceOfElementLocated(by));
                break;
            case VISIBLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
                break;
            case NONE:
                element = DriverManager.getDriver().findElement(by);
                break;
        }
        return element;
    }


    public static void waiTillVisible(By by ,int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitTillElementLoadedLonger(By by) {
        return this.waitTillElementLoaded(by, 40L);
    }

    public static WebElement waitTillElementLoaded(By by, long timeout) {
        return (WebElement)(new WebDriverWait(DriverManager.getDriver(), timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }





}