package ru.training.at.hw2.ex1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class JdiTestngTest {

    WebDriver driver;
    private static final String TESTING_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String TEST_LOGIN = "Roman";
    private static final String TEST_PSW = "Jdi1234";
    private List<WebElement> loginDropDownArrow;
    private WebElement loginInput;
    private WebElement pswInput;
    private WebElement submitLoginButton;

    @BeforeClass
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    // 1. Open test site by URL
    // 2. Assert browser title
    @Test
    public void openPageCheckTitle() {
        driver.get(TESTING_PAGE_URL);
        assertEquals(driver.getTitle(), "Home Page", "wrong title");
    }

    // 3. Perform login
    @Test(dependsOnMethods = "openPageCheckTitle")
    public void loginToApp() {
        loginDropDownArrow = driver.findElements(By.id("user-icon"));
        loginDropDownArrow.get(0).click();
        loginInput = driver.findElement(By.id("name"));
        loginInput.sendKeys(TEST_LOGIN);
        pswInput = driver.findElement(By.id("password"));
        pswInput.sendKeys(TEST_PSW);
        submitLoginButton = driver.findElement(By.id("login-button"));
        submitLoginButton.click();

        Dimension windowSize = driver.manage().window().getSize();
        Rectangle element = pswInput.getRect();
        element.toString();


    }


    @AfterClass
    public void browserTearDown() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        driver = null;
    }

}
