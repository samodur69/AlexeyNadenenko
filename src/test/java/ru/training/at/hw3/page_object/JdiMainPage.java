package ru.training.at.hw3.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class JdiMainPage extends BasePage {

    @FindBy(id = "user-icon")
    WebElement profilePhoto;

    @FindBy(id = "name")
    WebElement loginInput;

    @FindBy(id = "password")
    WebElement pswInput;

    @FindBy(id = "login-button")
    WebElement submitButton;

    @FindBy(id = "user-name")
    WebElement loggedUsername;

    @FindBy(className = "benefit-icon")
    List<WebElement> benefitsIcons;

    @FindBy(className = "benefit-txt")
    List<WebElement> benefitsText;

    @FindBy(id = "frame")
    WebElement frame;

    @FindBy(xpath = "//div[@class='card-body']/*[@class='btn btn-info']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//*[@class='sidebar-menu left']/child::li")
    List<WebElement> leftMenu;


    public JdiMainPage() {
        super();
    }

    public void openPage() {
        driver.get(prop.getProperty("TEST_URL"));
    }

    public void logIn() {
        profilePhoto.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(profilePhoto));
        loginInput.sendKeys(prop.getProperty("LOGIN"));
        pswInput.sendKeys(prop.getProperty("PSW"));
        submitButton.click();
    }

    public String getLoggedUserName() {
        if (loggedUsername.isDisplayed()) {
            return loggedUsername.getText();
        } else {
            return "username not displayed";
        }
    }

    public boolean compareHeaderMenuItems(List<String> expected) {
        return webElComparator(headerMenu, expected);
    }

    public void clickHeaderMenuItem(String item) {
        for (WebElement el : headerMenu) {
            if (el.getText().equals(item)) {
                el.click();
            }
        }
    }

    public int countBenefitIcons() {
        return benefitsIcons.size();
    }

    public boolean checkBenefitTexts(List<String> expected) {
        return webElComparator(benefitsText, expected);
    }

    public boolean checkFrameIsDisplayed() {
        return frame.isDisplayed();
    }

    public boolean switchToFrameAndCheckButton() {
        try {
            driver.switchTo().frame(frame);
            if (buttonSubmit.isDisplayed()) {
                return true;
            }
        } finally {
            driver.switchTo().defaultContent();
        }
        return false;
    }

    public boolean compareLeftMenuItems(List<String> expected) {
        return webElComparator(leftMenu, expected);
    }


    private boolean webElComparator(List<WebElement> actual, List<String> expected) {
        if (actual.size() != expected.size()) {
            return false;
        }
        List<String> actualText = new ArrayList<>();
        for (WebElement el : actual) {
            if (!el.isDisplayed()) {
                return false;
            }
            actualText.add(el.getText());
        }
        return actualText.containsAll(expected);
    }
}
