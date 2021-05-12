package ru.training.at.hw3.ex1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw3.DriverManager;
import ru.training.at.hw3.page_object.JdiMainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiElementsDisplayedTest {

    WebDriver driver;
    JdiMainPage mainPage;
    Properties prop;

    @BeforeClass
    public void browserSetUp() {
        mainPage = new JdiMainPage();
        driver = DriverManager.setupDriver();
        try {
            FileInputStream fi =
                    new FileInputStream("src/test/java/ru/training/at/hw3/testData.properties");
            prop = new Properties();
            prop.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openPageAndCheckTitle() {
        mainPage.openPage();
        assertTrue(mainPage.checkTitle(prop.getProperty("homepage_title")));
    }

    @Test
    public void loginAndCheckLoggedUser() {

    }

    @Test
    public void jdiDisplayedElementsTest() {

        mainPage.logIn(); // refactor to args
        assertEquals(mainPage.getLoggedUserName(), prop.getProperty("USERNAME"));


        List<String> expectedHeaderMenu = new ArrayList<>();
        assertTrue(mainPage.compareHeaderMenuItems(expectedHeaderMenu));

        assertEquals(mainPage.countBenefitIcons(), 4);
        List<String> benefitTexts = new ArrayList<>();

        assertTrue(mainPage.checkBenefitTexts(benefitTexts));
        assertTrue(mainPage.checkFrameIsDisplayed());
        assertTrue(mainPage.switchToFrameAndCheckButton());

        List<String> expectedLeftMenu = new ArrayList<>();
        mainPage.compareLeftMenuItems(expectedLeftMenu);


    }

    @Test
    public void checkLeftMenuItems() {
        List<String> expected = Arrays
                .asList(prop.getProperty("MENU_0"),
                        prop.getProperty("MENU_1"),
                        prop.getProperty("MENU_2"),
                        prop.getProperty("MENU_3"),
                        prop.getProperty("MENU_4"));
//        expected.replaceAll(String::toUpperCase);
        assertTrue(mainPage.compareLeftMenuItems(expected), "left menu incorrect");
    }


    @AfterClass
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
