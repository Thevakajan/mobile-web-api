package com.automate.listeners;

import com.automate.utils.configloader.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private int maxRetry = Integer.parseInt(PropertyUtils.getPropertyValue("retry_count"));

    public Retry() throws IOException {
    }

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        try {
            if (PropertyUtils.getPropertyValue("retry_failed_tests").equalsIgnoreCase("yes")) {
                value = count < maxRetry ? true : false;
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
