package ru.training.at.hw3.ex1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw3.Utils.DriverManager;
import ru.training.at.hw3.page_object.JdiMainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiElementsDisplayedTest {

    WebDriver driver;
    JdiMainPage mainPage;
    Properties prop;

    @BeforeClass (alwaysRun = true)
    public void browserSetUp() {
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
        mainPage = new JdiMainPage();
        mainPage.openPage();
        assertTrue(mainPage.checkTitle(prop.getProperty("homepage_title")), "wrong title");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitle")
    public void loginAndCheckLoggedUser() {
        mainPage.logIn(prop.getProperty("LOGIN"), prop.getProperty("PSW"));
        assertEquals(mainPage.getLoggedUserName(), prop.getProperty("USERNAME"));
    }

    @Test (dependsOnMethods = "openPageAndCheckTitle",
    enabled = false)
    public void checkHeaderMenuItems() {
        List<String> expectedHeaderMenu = Arrays
                .asList(prop.getProperty("MENU_0"),
                        prop.getProperty("MENU_1"),
                        prop.getProperty("MENU_2"),
                        prop.getProperty("MENU_3"));
        expectedHeaderMenu.replaceAll(String::toUpperCase);

        assertTrue(mainPage.compareLeftMenuItems(expectedHeaderMenu),
                "header menu items incorrect");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitle")
    public void checkBenefitsIconsAndTexts() {
        assertEquals(mainPage.countBenefitIcons(), 4,
                "wrong amount of benefits icons");
        List<String> benefitTexts = Arrays
                .asList(prop.getProperty("BENEFIT_0"),
                        prop.getProperty("BENEFIT_1"),
                        prop.getProperty("BENEFIT_2"),
                        prop.getProperty("BENEFIT_3"));

        assertTrue(mainPage.checkBenefitTexts(benefitTexts), "wrong benefits texts");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitle")
    public void checkFrameExistSwitchToItAndBack() {
        //TODO change frame switch logic
        assertTrue(mainPage.checkFrameIsDisplayed(), "expected frame does not exist");
        assertTrue(mainPage.switchToFrameAndCheckButton(), "expected button does not exist");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitle")
    public void checkLeftMenuItems() {
        List<String> expected = Arrays
                .asList(prop.getProperty("MENU_0"),
                        prop.getProperty("MENU_1"),
                        prop.getProperty("MENU_2"),
                        prop.getProperty("MENU_3"),
                        prop.getProperty("MENU_4"));
        assertTrue(mainPage.compareLeftMenuItems(expected), "left menu incorrect");
    }

    @AfterClass (alwaysRun = true)
    public void browserTearDown() {
        DriverManager.closeBrowser();
    }
}
