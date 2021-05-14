package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.pageobjects.JdiMainPage;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Owner(value = "Alexey Nadenenko")
public class ExerciseOne extends BaseTest {

    @SuppressWarnings("checkstyle:MethodName")
    @Test
    @Story(value = "JDI test page UI testing")
    @Feature(value = "Check benefits and frames")
    public void exerciseOneTest() {

        // Open page and login
        openPageAndCheckTitle(prop.getProperty("homepage_title"));
        loginAndCheckLoggedUser(
                prop.getProperty("LOGIN"),
                prop.getProperty("PSW"),
                prop.getProperty("USERNAME"));

        // Prepare expected left menu items and compare with actual
        List<String> expectedHeaderMenu = Arrays
                .asList(prop.getProperty("MENU_0"),
                        prop.getProperty("MENU_1"),
                        prop.getProperty("MENU_2"),
                        prop.getProperty("MENU_3"));
        expectedHeaderMenu.replaceAll(String::toUpperCase);
        checkHeaderMenuItems(expectedHeaderMenu);

        // Prepare expected benefits texts and compare with actual
        List<String> benefitTexts = Arrays
                .asList(prop.getProperty("BENEFIT_0"),
                        prop.getProperty("BENEFIT_1"),
                        prop.getProperty("BENEFIT_2"),
                        prop.getProperty("BENEFIT_3"));
        checkBenefitsIconsAndTexts(benefitTexts, 4);

        // Switch to iframe, check button and switch back to main window
        checkFrameExistSwitchToItAndBack();

        // Prepare expected left menu items and compare
        List<String> expected = Arrays
                .asList(prop.getProperty("MENU_0"),
                        prop.getProperty("MENU_1"),
                        prop.getProperty("MENU_2"),
                        prop.getProperty("MENU_3"),
                        prop.getProperty("MENU_4"));
        checkLeftMenuItems(expected);
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

    @Step(value = "Check header menu items and compare with {expectedHeaderMenu}")
    public void checkHeaderMenuItems(List<String> expectedHeaderMenu) {
        listElementsComparator(
                mainPage
                .getHeaderMenu()
                .getHeaderMenuItems(), expectedHeaderMenu, "header menu items");
    }

    @Step(value = "Check benefits: {amount} images, {benefitTexts} under images")
    public void checkBenefitsIconsAndTexts(List<String> benefitTexts, int amount) {
        assertEquals(mainPage.countBenefitIcons(), amount,
                "wrong amount of benefits icons");
        listElementsComparator(mainPage
                .getBenefitsTexts(), benefitTexts, "benefit text");
    }

    @Step(value = "Switch to frame check if button exist and switch back to main window")
    public void checkFrameExistSwitchToItAndBack() {
        assertTrue(mainPage.checkFrameIsDisplayed(), "expected frame does not exist");
        assertTrue(mainPage.switchToFrameAndCheckButton(), "expected button does not exist");
    }

    @Step(value = "Compare items in left menu with expected: {expected}")
    public void checkLeftMenuItems(List<String> expected) {
        listElementsComparator(mainPage.getLeftMenu().getLeftMenuItems(), expected, "left menu");
    }
}
