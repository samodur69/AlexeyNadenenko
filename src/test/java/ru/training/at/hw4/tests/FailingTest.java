package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.pageobjects.JdiDifferentPage;

import java.util.List;
import java.util.Locale;

@Owner(value = "Alexey Nadenenko")
public class FailingTest extends BaseTest {

    @Test
    @Story(value = "")
    @Feature(value = "")
    public void exerciseTwoTest() {
        // Open page and login
        openPageAndCheckTitle(prop.getProperty("homepage_title"));
        loginAndCheckLoggedUser(
                prop.getProperty("LOGIN"),
                "1234",
                prop.getProperty("USERNAME"));

        navigateToDiffPage("Different Elements");

        // select items
        // point to crash
        selectNecessaryItems(
                prop.getProperty("checkbox1"),
                prop.getProperty("checkbox2"),
                prop.getProperty("radio1"),
                prop.getProperty("colorDropdown"));

        // verify log... Hardcoded regexp
        checkLogItems();
    }

    @Step(value = "Choose menu item {menuItem} and navigate to page. Check title")
    public void navigateToDiffPage(String menuItem) {
        mainPage.getHeaderMenu().clickHeaderServiceMenuItem(menuItem.toUpperCase(Locale.ROOT));
        diffPage = new JdiDifferentPage(driver);
        Assert.assertEquals(diffPage.getTitleOfPage(), menuItem);
    }

    @Step(value = "Select expected items: "
            + "checkbox {checkbox1}, checkbox {checkbox2},"
            + " Radio {metal} and dropdown {color}")
    public void selectNecessaryItems(String checkbox1,
                                     String checkbox2,
                                     String metal,
                                     String color) {
        diffPage.checkBoxSelect(checkbox1);
        diffPage.checkBoxSelect(checkbox2);
        diffPage.radioSelect(metal);
        diffPage.dropdownColorSelect(color);
    }

    @Step(value = "Verify log items")
    public void checkLogItems() {
        List<String> actual = diffPage.getLogItems();

        SoftAssert logAssert = new SoftAssert();
        logAssert.assertTrue(actual.size() == 4);
        logAssert.assertTrue(actual.get(0).matches(".*(Colors).*(Yellow)"));
        logAssert.assertTrue(actual.get(1).matches(".*(metal).*(Selen)"));
        logAssert.assertTrue(actual.get(2).matches(".*(Wind).*(true)"));
        logAssert.assertTrue(actual.get(3).matches(".*(Water).*(true)"));
        logAssert.assertAll("wrong logs found");
    }
}
