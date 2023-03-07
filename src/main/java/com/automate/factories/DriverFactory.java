package com.automate.factories;

import com.automate.driver.MobileDriversSetup;
import com.automate.driver.DriverManager;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.util.Objects;

public final class DriverFactory {

    private DriverFactory() {}
    public static void initializeDriver(String mobilePlatformName, String devicename, String udid, int port, String emulator) throws IOException {
        AppiumDriver driver;
        switch (mobilePlatformName) {
            case "ANDROID_WEB":
                driver = MobileDriversSetup.createAndroidDriverForWeb( devicename,udid, port, emulator);
                break;
            case "IOS_WEB":
                driver = MobileDriversSetup.createIOSDriverForWeb(devicename, udid, port);
                break;
            default:
                throw new ExceptionInInitializerError("Platform name " + mobilePlatformName +"is not found. Please check the platform name");
        }
        DriverManager.setAndWebDriver(driver);
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }


}
