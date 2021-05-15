package ru.training.at.hw4.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.pageobjects.JdiDifferentPage;
import ru.training.at.hw4.pageobjects.JdiMainPage;
import ru.training.at.hw4.tests.utils.DriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseTest {

    protected JdiMainPage mainPage;
    protected JdiDifferentPage diffPage;
    protected Properties prop;
    protected WebDriver driver;

    @Step(value = "Browser setup, read properties")
    @BeforeClass(alwaysRun = true)
    public void browserSetUp(ITestContext context) {
        //        WebDriverManager.chromedriver().setup();
        //        driver = new ChromeDriver();
        //        driver.manage().window().maximize();
        //        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver = DriverManager.getChromeDriver();
        context.setAttribute("driver", driver);
        try {
            FileInputStream fi =
                    new FileInputStream("src/test/java/ru/training/at/hw3/testData.properties");
            prop = new Properties();
            prop.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Step(value = "Browser tear down")
    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Step(value = "Open JDI Main Page and check title {title}")
    public void openPageAndCheckTitle(String title) {
        mainPage = new JdiMainPage(driver);
        mainPage.openPage();
        assertTrue(mainPage.checkTitle(title), "wrong title");
    }

    @Step(value = "Login as: {username} / {psw} . Assert that logged user Full Name is {expected}")
    public void loginAndCheckLoggedUser(String username, String psw, String expected) {
        mainPage.logIn(username, psw);
        assertEquals(mainPage.getLoggedUserName(), expected);
    }

    @Step(value = "Compare two List objects: actual web element and expected text")
    protected void listElementsComparator(List<String> actual, List<String> expected, String item) {
        Assert.assertEquals(actual.size(), expected.size(), item + " is not expected");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < actual.size(); i++) {
            softAssert.assertTrue(actual.get(i).equals(expected.get(i)));
        }
        softAssert.assertAll(item + " is not expected");
    }
}
