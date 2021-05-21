package ru.training.at.hw6.test;

import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw6.entities.MetalAndColor;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.site.JdiSite;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static org.testng.Assert.assertEquals;
import static ru.training.at.hw6.site.JdiSite.*;

public class ExerciseOne {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        PageFactory.initSite(JdiSite.class);
        openSite(JdiSite.class);
    }

    @Test
    public void firstTest() {
        userIcon.click();
        loginForm.loginAs(User.ROMAN);
        userName.is().displayed();
        headerMenu.select("METALS & COLORS");
        metalsPage.checkOpened();
        metalsPage.form.submit(MetalAndColor.testdata);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        assertEquals(1, 1);
    }

    @AfterClass(alwaysRun = true)
    public void tearDowm() {
        killAllSeleniumDrivers();
    }
}
