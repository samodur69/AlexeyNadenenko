package ru.training.at.hw4.tests.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotMaker implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("wazzzup");
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        System.out.println("screen");
        return screenShot;
    }
}