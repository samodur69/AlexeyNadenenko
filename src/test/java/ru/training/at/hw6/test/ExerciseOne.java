package ru.training.at.hw6.test;

import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.*;
import ru.training.at.hw6.entities.MetalAndColor;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.site.JdiSite;
import ru.training.at.hw6.utils.TestData;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static org.testng.Assert.assertEquals;
import static ru.training.at.hw6.site.JdiSite.*;

public class ExerciseOne {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        PageFactory.initSite(JdiSite.class);
        openSite(JdiSite.class);
    }

    @Test(dataProvider = "jsonData", dataProviderClass = TestData.class)
    public void firstTest(MetalAndColor testData) {
        homePage.open();
        userIcon.click();
        if(!userName.isVisible()) {
            loginForm.loginAs(User.ROMAN);
        }
        headerMenu.select("METALS & COLORS");
        metalsPage.checkOpened();
        metalsPage.form.submit(testData);
        userIcon.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(1, 1);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDowm() {
        killAllSeleniumDrivers();
    }
}
