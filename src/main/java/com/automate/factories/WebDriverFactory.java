package com.automate.factories;

import com.automate.driver.DriverManager;
import com.automate.driver.WebDriverSetup;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public final class WebDriverFactory {

    private WebDriverFactory() {}
    public static void initializeWebDriver(String mobilePlatformName, Platform platform, String browser ) throws IOException {
        WebDriver driver;
        switch (mobilePlatformName) {
            case "Web":
                driver = WebDriverSetup.createWebDriver(browser);
                break;
            case "Browserstack":
                driver= WebDriverSetup.setupBrowser(platform,browser);
                break;

            default:
                throw new ExceptionInInitializerError("Platform name " + mobilePlatformName +"is not found. Please check the platform name");
        }
        DriverManager.setAndWebDriver(driver);
    }
}
