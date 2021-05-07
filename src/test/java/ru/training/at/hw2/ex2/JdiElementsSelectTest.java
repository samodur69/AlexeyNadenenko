package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.JdiTestData;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JdiElementsSelectTest {
    WebDriver driver;

    @BeforeClass
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void jdiDisplayedElementsTest() {
        //  1. Open test site by URL
        driver.get(JdiTestData.TESTING_PAGE_URL);

        //  2. Assert Browser Title
        Assert.assertEquals(driver.getTitle(), "Home Page", "wrong browser title");

        //  3. Perform login. Click to empty profile photo to open dropdown
        List<WebElement> loginDropDownArrow = driver
                .findElements(By.xpath("//a[@class='dropdown-toggle']/*[@class='profile-photo']"));
        loginDropDownArrow.get(0).click();
        //  search for login input field
        WebElement loginInput = driver.findElement(By.id("name"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(loginInput));
        loginInput.sendKeys(JdiTestData.TEST_LOGIN);
        // search for password input field
        WebElement pswInput = driver.findElement(By.id("password"));
        pswInput.sendKeys(JdiTestData.TEST_PSW);
        //  search for submit button
        WebElement submitLoginButton = driver.findElement(By.id("login-button"));
        submitLoginButton.click();

        //  4. Assert Username is logged
        SoftAssert loginAssert = new SoftAssert();
        WebElement loggedUsername = driver.findElement(By.id("user-name"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(loggedUsername));
        loginAssert.assertTrue(loggedUsername.isDisplayed());
        loginAssert.assertEquals(loggedUsername.getText(), JdiTestData.TEST_USERNAME);
        loginAssert.assertAll("wrong username displayed when user logged");

        //  5. Open through the header menu Service -> Different
        WebElement serviceDropDown = driver.findElement(By.linkText("Service"));
        serviceDropDown.click();
        WebElement diffElemItem = driver.findElement(By.linkText("Different elements"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(diffElemItem));
        diffElemItem.click();

        //  6. Select checkboxes Water & Wind
        List<WebElement> checkBoxes = driver
                .findElements(By.xpath("//*[@class='label-checkbox']/input"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(checkBoxes));
        //  water checkbox
        checkBoxes.get(0).click();
        //  wind checkbox
        checkBoxes.get(2).click();
        // here we can use for-each cycle to search by name

        //  7. Select Selen radio
        List<WebElement> radio = driver
                .findElements(By.xpath("//*[@class='label-radio']/input"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(radio));
        radio.get(3).click();
        // here we can use for-each cycle to search by name

        //  8. Select dropdown
        Select select = new Select(driver
                .findElement(By.xpath("//*[@class='colors']/select")));
        select.selectByVisibleText("Yellow");

        //  9. Check Log for items status
        SoftAssert logAssert = new SoftAssert();
        List<WebElement> logItems = driver
                .findElements(By.xpath("//*[@class='panel-body-list logs']/li"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(logItems));
        logAssert.assertTrue(logItems.size() == 4);
        logAssert.assertTrue(logItems.get(0).getText().matches(".*(Colors).*(Yellow)"));
        logAssert.assertTrue(logItems.get(1).getText().matches(".*(metal).*(Selen)"));
        logAssert.assertTrue(logItems.get(2).getText().matches(".*(Wind).*(true)"));
        logAssert.assertTrue(logItems.get(3).getText().matches(".*(Water).*(true)"));
        logAssert.assertAll("wrong logs found");
    }


    @AfterClass
    public void browserTearDown() {
        //  10. Close Browser
        driver.quit();
        driver = null;
    }

}
