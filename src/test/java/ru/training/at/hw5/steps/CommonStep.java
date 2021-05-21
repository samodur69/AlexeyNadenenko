package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.enity.User;
import ru.training.at.hw5.pageobjects.JdiDifferentPage;
import ru.training.at.hw5.pageobjects.JdiHeaderMenu;
import ru.training.at.hw5.pageobjects.JdiMainPage;
import ru.training.at.hw5.pageobjects.JdiUserTable;

public class CommonStep {

    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);

    @Given("I open JDI Github site")
    public void openJdiHomepage() {
        new JdiMainPage(driver)
               .openPage();
    }

    @Given("I login as user {string}")
    public void loginToJdiHomepage(String fullName) {
        if (fullName.equals(User.ROMAN_IOVLEV.getFullName())) {
            new JdiMainPage(driver)
                    .logIn(
                            User.ROMAN_IOVLEV.getLogin(),
                            User.ROMAN_IOVLEV.getPassword());
        }
    }

    @When("I click on {string} button in Header")
    public void clickOnButtonInHeader(String headerMenuButton) {
        new JdiHeaderMenu(driver)
                .clickHeaderMenuButton(headerMenuButton);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String item) {
        new JdiHeaderMenu(driver)
                .clickHeaderSubMenu(item);
    }

    @When("I select checkboxes {string} and {string}")
    public void selectCheckBoxesOnJdiDifferentPage(String first, String second) {
        new JdiDifferentPage(driver)
                .checkBoxSelect(first)
                .checkBoxSelect(second);
    }

    @When("I select radio {string}")
    public void selectRadioOnJdiDifferentPage(String item) {
        new JdiDifferentPage(driver)
                .radioSelect(item);
    }

    @When("I select {string} in dropdown")
    public void selectColorDropdownOnDifferentPage(String item) {
        new JdiDifferentPage(driver)
                .dropdownColorSelect(item);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectCheckBoxVipOnUserTablePage(String username) {
        new JdiUserTable(driver).selectCheckBoxOnUserTablePage(username);
    }
}
