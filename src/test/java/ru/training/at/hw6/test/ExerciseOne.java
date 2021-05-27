package ru.training.at.hw6.test;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw6.entities.MetalAndColor;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.site.components.Results;
import ru.training.at.hw6.utils.TestData;
import java.util.Arrays;

import static ru.training.at.hw6.site.JdiSite.*;
import static ru.training.at.hw6.site.components.Results.*;

public class ExerciseOne implements BaseTest {

    @Test(dataProvider = "jsonData", dataProviderClass = TestData.class)
    public void firstTest(MetalAndColor testData) {
        homePage.open();
        userIcon.click();
        if (!userName.isVisible()) {
            loginForm.loginAs(User.ROMAN);
        }
        headerMenu.select("METALS & COLORS");
        metalsPage.checkOpened();
        metalsPage.form.submit(testData);
        assertResults(testData);
    }

    private void assertResults(MetalAndColor testData) {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(Results.getSummary(), Arrays.stream(testData.getSummary()).sum());
        sa.assertEquals(getTextElementValuesArray(elements), testData.getElements());
        sa.assertEquals(getTextElementValue(color), testData.getColor());
        sa.assertEquals(getTextElementValue(metal), testData.getMetals());
        sa.assertEquals(getTextElementValuesArray(vegetables), testData.getVegetables());
        sa.assertAll("Wrong result section");
    }

    @AfterMethod
    public void logOut() {
        if (userName.isDisplayed()) {
            userIcon.click();
            logoutButton.click();
        }
    }
}
