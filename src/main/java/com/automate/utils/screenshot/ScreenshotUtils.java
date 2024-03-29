package com.automate.utils.screenshot;

import com.automate.constants.FrameworkConstants;
import com.automate.driver.DriverManager;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public final class ScreenshotUtils {

    private ScreenshotUtils() {}

    // This class is to handle the change in third party library
    @SneakyThrows
    public static void captureScreenshotAsFile(String testName) {
        File source = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File destination = new File(FrameworkConstants.getScreenshotPath() + File.separator + testName + ".png");
        FileUtils.copyFile(source, destination);
    }

    public static String captureScreenshotAsBase64() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
