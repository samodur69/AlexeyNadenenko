package ru.training.at.hw6.test;

import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.site.JdiSite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;

public interface BaseTest {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        PageFactory.initSite(JdiSite.class);
        openSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    default void tearDowm() {
        killAllSeleniumDrivers();
    }
}
