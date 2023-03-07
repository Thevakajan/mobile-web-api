package com.automate.listeners;

import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.reports.ExtentReportLogStatus;
import com.automate.reports.ExtentReportManager;
import org.testng.*;

import java.io.IOException;

public class Listeners implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReportManager.initExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
        ExtentReportManager.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentReportManager.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
        ExtentReportManager.addDevices();
        ExtentReportLogStatus.logInfo("Test - <b>" + result.getMethod().getMethodName() + "</b> is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentReportLogStatus.logPass("Test - <b>" + result.getMethod().getMethodName() + "</b> is passed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentReportLogStatus.logFail("Test - <b>" + result.getMethod().getMethodName() + "</b> is failed", result.getThrowable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            ExtentReportLogStatus.logSkip("Test - <b>" + result.getMethod().getMethodName() + "</b> is skipped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportManager.flushExtentReport();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No implementation
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
