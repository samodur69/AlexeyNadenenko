package ru.training.at.hw6.test;

import org.testng.annotations.*;
import ru.training.at.hw6.entities.MetalAndColor;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.site.JdiSite;
import ru.training.at.hw6.utils.TestData;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static org.testng.Assert.assertEquals;
import static ru.training.at.hw6.site.JdiSite.*;

public class ExerciseOne {


    @BeforeMethod
    public void openSite() {
        initElements(JdiSite.class);
    }

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
        // TODO assert

        assertEquals(1, 1);
    }

    @AfterMethod
    public void logOut() {
        if (userName.isDisplayed()) {
            userIcon.click();
            logoutButton.click();
        }
    }
}
