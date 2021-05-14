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
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    //    @Attachment(type = "image/png", fileExtension = ".png")
    //    public byte[] attachScreenshot(WebDriver webDriver) {
    //        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    //    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}