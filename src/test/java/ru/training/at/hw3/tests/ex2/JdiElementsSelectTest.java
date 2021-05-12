package ru.training.at.hw3.tests.ex2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pageobjects.JdiDifferentPage;
import ru.training.at.hw3.pageobjects.JdiMainPage;
import ru.training.at.hw3.tests.BaseTest;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiElementsSelectTest extends BaseTest {

    private JdiMainPage mainPage;
    private JdiDifferentPage diffPage;

    @Test
    public void openPageAndCheckTitleTest() {
        mainPage = new JdiMainPage(driver);
        mainPage.openPage();
        assertTrue(mainPage.checkTitle(prop.getProperty("homepage_title")), "wrong title");
    }

    @Test (dependsOnMethods = "openPageAndCheckTitleTest")
    public void loginAndCheckLoggedUser() {
        mainPage.logIn(prop.getProperty("LOGIN"), prop.getProperty("PSW"));
        assertEquals(mainPage.getLoggedUserName(), prop.getProperty("USERNAME"));
    }

    @Test (dependsOnMethods = "loginAndCheckLoggedUser")
    public void navigateToDiffPage() {
        mainPage.getHeaderMenu().clickHeaderServiceMenuItem("DIFFERENT ELEMENTS");
        diffPage = new JdiDifferentPage(driver);
        //  Web driver wait in getTitleOfPage Method. This is not correct, but working
        //  Better to use JS command
        assertEquals(diffPage.getTitleOfPage(), "Different Elements");
    }

    @Test (dependsOnMethods = "navigateToDiffPage")
    public void selectNecessaryItemsAndAssertLogTest() {
        diffPage.checkBoxSelect(prop.getProperty("checkbox1"));
        diffPage.checkBoxSelect(prop.getProperty("checkbox2"));
        diffPage.radioSelect(prop.getProperty("radio1"));
        diffPage.dropdownColorSelect(prop.getProperty("colorDropdown"));

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
