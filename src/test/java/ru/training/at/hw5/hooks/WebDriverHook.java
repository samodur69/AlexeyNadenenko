package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.training.at.hw5.context.TestContext;

import java.util.concurrent.TimeUnit;

public class WebDriverHook {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        TestContext.getInstance().setTestObject(TestContext.WEB_DRIVER, driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getInstance().cleanContext();
    }
}
