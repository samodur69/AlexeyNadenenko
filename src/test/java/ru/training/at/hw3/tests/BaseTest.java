package ru.training.at.hw3.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pageobjects.JdiMainPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected JdiMainPage mainPage;
    protected Properties prop;
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            FileInputStream fi =
                    new FileInputStream("src/test/java/ru/training/at/hw3/testData.properties");
            prop = new Properties();
            prop.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    protected void listElementsComparator(List<String> actual, List<String> expected, String item) {
        Assert.assertEquals(actual.size(), expected.size(), item + " is not expected");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < actual.size(); i++) {
            softAssert.assertTrue(actual.get(i).equals(expected.get(i)));
        }
        softAssert.assertAll(item + " is not expected");
    }
}
