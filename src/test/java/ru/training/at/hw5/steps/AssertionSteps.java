package ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.context.Utils;
import ru.training.at.hw5.pageobjects.JdiDifferentPage;
import ru.training.at.hw5.pageobjects.JdiHeaderMenu;
import ru.training.at.hw5.pageobjects.JdiUserTable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AssertionSteps {

    WebDriver driver = TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER);

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
            Assert.assertTrue(actualItems.get(i).matches(regex.get(i)),
                    "log incorrect. %s expected");
        }
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDropDownsOnUserTablePage(int expected) {
        Assert.assertEquals(new JdiUserTable(driver)
                        .getNumberTypesDropdowns().size(),
                expected,
                "wrong number of dropdowns");
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void verifyNumberOfUsernamesOnUserTablePage(int expected) {
        Assert.assertEquals(new JdiUserTable(driver)
                        .getUserNames().size(),
                expected, "wrong number of usernames");
    }

    @Then("{int} Description texts under"
            + " images should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDescriptionsOnUserTablePage(int expected) {
        Assert.assertEquals(new JdiUserTable(driver)
                        .getUserImageDescriptions().size(),
                expected, "wrong number of image descriptions");
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void verifyNumberOfCheckboxesOnUserTablePage(int expected) {
        Assert.assertEquals(new JdiUserTable(driver)
                        .getUserCheckboxes().size(),
                expected, "wrong number of usernames");
    }

    @Then("{int} log row has {string} text in log section")
    public void verifyLogRowForCheckbox(int countExpected, String expected) {
        Assert.assertEquals(new JdiUserTable(driver)
                .getLogItems().size(),
                countExpected, "wrong number of log items");

        Assert.assertTrue(new JdiUserTable(driver)
                .getLogItems()
                .get(0).getText()
                .contains(expected), "wrong log item");
    }

    @Then("User table should contain following values:")
    public void verifyUserDescription(DataTable dataTable) {
        // prepare datatable to List<List<String>>
        // Delete first row with description
        // Assert with parsed table
        Assert.assertEquals(
                dataTable
                        .asLists()
                        .stream().skip(1)
                        .collect(Collectors.toList()),
                new JdiUserTable(driver).parseUserTableForTest());
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void verifyDroplistForUserOnUserTablePage(List<String> expected) {
        // from expected in assertion skip first row
        for (int i = 0; i < expected.size() - 1; i++) {
            Assert.assertEquals(new JdiUserTable(driver)
                            .getDropdownOptions()
                            .get(i).getText(),
                    expected
                            .stream()
                            .skip(1)
                            .collect(Collectors.toList())
                            .get(i));
        }
    }
}