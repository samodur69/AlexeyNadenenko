package ru.training.at.hw3.tests.ex1;

import org.testng.annotations.Test;
import ru.training.at.hw3.pageobjects.JdiMainPage;
import ru.training.at.hw3.tests.BaseTest;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiElementsDisplayedTest extends BaseTest {

    @Test
    public void openPageAndCheckTitleTest() {
        mainPage = new JdiMainPage();
        mainPage.openPage();
        assertTrue(mainPage.checkTitle(prop.getProperty("homepage_title")), "wrong title");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitleTest")
    public void loginAndCheckLoggedUserTest() {
        mainPage.logIn(prop.getProperty("LOGIN"), prop.getProperty("PSW"));
        assertEquals(mainPage.getLoggedUserName(), prop.getProperty("USERNAME"));
    }

    @Test (dependsOnMethods = "openPageAndCheckTitleTest")
    public void checkHeaderMenuItemsTest() {
        List<String> expectedHeaderMenu = Arrays
                .asList(prop.getProperty("MENU_0"),
                        prop.getProperty("MENU_1"),
                        prop.getProperty("MENU_2"),
                        prop.getProperty("MENU_3"));
        expectedHeaderMenu.replaceAll(String::toUpperCase);

        listElementsComparator(
                mainPage
                .getHeaderMenu()
                .getHeaderMenuItems(), expectedHeaderMenu, "header menu items");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitleTest")
    public void checkBenefitsIconsAndTextsTest() {
        assertEquals(mainPage.countBenefitIcons(), 4,
                "wrong amount of benefits icons");
        List<String> benefitTexts = Arrays
                .asList(prop.getProperty("BENEFIT_0"),
                        prop.getProperty("BENEFIT_1"),
                        prop.getProperty("BENEFIT_2"),
                        prop.getProperty("BENEFIT_3"));
        listElementsComparator(mainPage
                .getBenefitsTexts(), benefitTexts, "benefit text");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitleTest")
    public void checkFrameExistSwitchToItAndBackTest() {
        //TODO change frame switch logic
        assertTrue(mainPage.checkFrameIsDisplayed(), "expected frame does not exist");
        assertTrue(mainPage.switchToFrameAndCheckButton(), "expected button does not exist");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitleTest")
    public void checkLeftMenuItemsTest() {
        List<String> expected = Arrays
                .asList(prop.getProperty("MENU_0"),
                        prop.getProperty("MENU_1"),
                        prop.getProperty("MENU_2"),
                        prop.getProperty("MENU_3"),
                        prop.getProperty("MENU_4"));
        listElementsComparator(mainPage.getLeftMenu().getLeftMenuItems(), expected, "left menu");
    }
}
