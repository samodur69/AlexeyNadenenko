package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.JdiTestData;

import java.util.ArrayList;
import java.util.List;

public class JdiElementsDisplayedTest {

    WebDriver driver;

    @BeforeClass
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        loginAssert.assertTrue(loggedUsername.isDisplayed());
        loginAssert.assertEquals(loggedUsername.getText(), JdiTestData.TEST_USERNAME);
        loginAssert.assertAll("wrong username displayed when user logged");

        //  5. Assert header element displayed
        //  to follow DRY concept i use own web Element Comparator
        //  First arg - List of web elements, second - prepared Expected data list,
        //  third - name of checking element to use it in assertion message
        List<WebElement> headerMenu = driver
                .findElements(By
                        .xpath("//*[@class='uui-navigation nav navbar-nav m-l8']/child::li"));
        List<String> expected = new ArrayList<>(JdiTestData.headerMenu);
        //  Header menu has the same items like in left menu but in uppercase
        //  so i change it Case
        expected.replaceAll(String::toUpperCase);
        webElComparator(headerMenu, expected, "Header menu");


        //  6. Assert that 4 images (icons) on the page
        List<WebElement> benefitIcons = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(benefitIcons.size(), 4);

        //  7. Assert that there are 4 texts under images
        List<WebElement> textUnderBenefitIcons = driver.findElements(By.className("benefit-txt"));
        webElComparator(textUnderBenefitIcons, JdiTestData.benefits, "benefits text");

        //  8. Assert iframe with Frame button exist
        Assert.assertTrue(driver.findElement(By.id("frame")).isDisplayed());

        //  9. Switch to iframe and check Frame Button exist
        // try finally i use for case driver can`t switch to frame.
        try {
            driver.switchTo().frame("frame");
            Assert.assertTrue(driver
                    .findElement(By.xpath("//div[@class='card-body']/*[@class='btn btn-info']"))
                    .isDisplayed());
        } finally {
            //  10. Switch to original window back
            driver.switchTo().defaultContent();
        }

        //  11. Assert 5 items in Left Section
        List<WebElement> leftMenu = driver
                .findElements(By.xpath("//*[@class='sidebar-menu left']/child::li"));
        webElComparator(leftMenu, JdiTestData.leftMenu, "left menu");

    }

    private void webElComparator(List<WebElement> actual, List<String> expected, String item) {
        Assert.assertEquals(actual.size(), expected.size(), item + " is not expected");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < actual.size(); i++) {
            softAssert.assertTrue(actual.get(i).getText().equals(expected.get(i)));
            softAssert.assertTrue(actual.get(i).isDisplayed());
        }
        softAssert.assertAll(item + " is not expected");
    }

    @AfterClass
    public void browserTearDown() {
        //  12. Close Browser
        driver.quit();
        driver = null;
    }
}
