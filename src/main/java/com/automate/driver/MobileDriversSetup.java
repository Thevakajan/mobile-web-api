package com.automate.driver;


import com.automate.constants.FrameworkConstants;
import com.automate.utils.configloader.JsonUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;


public final class MobileDriversSetup {

    private MobileDriversSetup() {
    }


    public static AppiumDriver<MobileElement> createAndroidDriverForWeb(String device_name, String udid, int port, @NotNull String emulator) throws IOException {

            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
            capability.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
            capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            capability.setCapability(MobileCapabilityType.UDID, udid);
            capability.setCapability(CapabilityType.BROWSER_NAME,"Chrome" );
            capability.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

            capability.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, FrameworkConstants.getChromedriverExecutablesPath());
            capability.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_PORT, port); // For Web view/Chrome browser to launch the browser on different port
            if (emulator.equalsIgnoreCase("yes")) {
                capability.setCapability(AndroidMobileCapabilityType.AVD, "SMJ700F");
                capability.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, "avdLaunchTimeout");
            }

          return new AndroidDriver<>(new URL(JsonUtils.getValue("appium_url")), capability);

    }


    public static AppiumDriver<MobileElement> createIOSDriverForWeb(String device_name, String udid, int port) throws IOException {

            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
            capability.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
            capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capability.setCapability(MobileCapabilityType.UDID, udid);
            capability.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "bundleId");
            capability.setCapability(CapabilityType.BROWSER_NAME,"Safari");
            capability.setCapability("webkitDebugProxyPort", port); // For web view/Safari browser testing on real device

          return new AndroidDriver<>(new URL(JsonUtils.getValue("appium_url")), capability);

    }



}
