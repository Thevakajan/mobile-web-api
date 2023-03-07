package com.automate.reports;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;
import com.automate.constants.FrameworkConstants;
import com.automate.driver.DriverManager;
import com.automate.enums.CategoryType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.media.jfxmediaimpl.platform.PlatformManager;

public final class ExtentReportManager {

    private ExtentReportManager() {
    }

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    static {
        try {
            extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final ThreadLocal<ExtentTest> threadLocalExtentTest = new ThreadLocal<>();

    private static InetAddress ip;
    private static String hostname;

    /**
     * This method is to initialize the Extent Report
     */
    public static void initExtentReport() {
        try {
            if (Objects.isNull(extentReports)) {
                extentReports = new ExtentReports();
                extentReports.attachReporter(extentSparkReporter);
                ip = InetAddress.getLocalHost();
                hostname = ip.getHostName();
                extentReports.setSystemInfo("Host Name", hostname);
                extentReports.setSystemInfo("Environment", "Mobile Automation - Appium");
                extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
                extentSparkReporter.config().setDocumentTitle("HTML Report");
                extentSparkReporter.config().setReportName("Mobile Automation Test");
                extentSparkReporter.config().setTheme(Theme.DARK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testCaseName) {
        setExtentTest(extentReports.createTest(testCaseName));
    }

    public static void flushExtentReport() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ExtentTest getExtentTest() {
        return threadLocalExtentTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        threadLocalExtentTest.set(test);
    }

    static void unload() {
        threadLocalExtentTest.remove();
    }

    public static void addAuthors(String[] authors) {
        for (String author : authors) {
            getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            getExtentTest().assignCategory(category.toString());
        }
    }

    public static void addDevices() {
        getExtentTest().assignDevice(DriverManager.getPlatformName() + "-" + DriverManager.getDeviceName());
    }
}
