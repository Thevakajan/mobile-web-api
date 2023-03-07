package com.automate.reports;

import com.automate.utils.configloader.PropertyUtils;
import com.automate.utils.screenshot.ScreenshotService;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.io.IOException;

public final class ExtentReportLogStatus {

    private ExtentReportLogStatus() {
    }

    public static void logPass(String message) throws IOException {
        if (PropertyUtils.getPropertyValue("passed_step_screenshots").equalsIgnoreCase("yes")) {
            ExtentReportManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build());
        } else {
            ExtentReportManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
        }
    }

    public static void logFail(String message, Throwable t) throws IOException {
        if (PropertyUtils.getPropertyValue("failed_step_screenshots").equalsIgnoreCase("yes")) {
            ExtentReportManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED))
                    .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build())
                    .fail(t);
        } else {
            ExtentReportManager.getExtentTest().fail(message).fail(t);
        }
    }

    public static void logSkip(String message) throws IOException {
        if (PropertyUtils.getPropertyValue("skipped_step_screenshots").equalsIgnoreCase("yes")) {
            ExtentReportManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build());
        } else {
            ExtentReportManager.getExtentTest().log(Status.SKIP, message);
        }
    }

    public static void logInfo(String message) {
        ExtentReportManager.getExtentTest().log(Status.INFO, message);
    }

    public static void warning(String message) {
        ExtentReportManager.getExtentTest().log(Status.WARNING, message);
    }
}
