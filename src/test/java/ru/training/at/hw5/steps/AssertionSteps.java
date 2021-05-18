package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.context.Utils;
import ru.training.at.hw5.pageobjects.JdiDifferentPage;
import ru.training.at.hw5.pageobjects.JdiHeaderMenu;

import java.util.*;

public class AssertionSteps {

    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);

    @Then("{string} page should be opened")
    public void assertionPageTitle(String expectedTitle) {
        Assert.assertEquals(
                new JdiHeaderMenu(driver).getPageTitle(),
                expectedTitle,
                "wrong page title");
    }

    @Then("Log field should contain following values")
    public void verifyLogItems(Map<String, String> expected) {
        List<String> actualItems = new JdiDifferentPage(driver)
                .getLogItems();
        List<String> regex = Utils.generateRegex(expected);
        for (int i = 0; i < actualItems.size(); i++) {
            Assert.assertTrue(actualItems.get(i).matches(regex.get(i)), "log incorrect");
        }
    }
}
