package ru.training.at.hw4.tests.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotMaker implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver webDriver = (WebDriver) result.getTestContext().getAttribute("webDriver");
        AttachmentUtil.attachScreenshot(webDriver);
    }


}