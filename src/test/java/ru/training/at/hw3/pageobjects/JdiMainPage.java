package ru.training.at.hw3.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    private final JdiHeaderMenu headerMenu;
    private final JdiLeftMenu leftMenu;
    WebDriver driver;

    public JdiMainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        headerMenu = new JdiHeaderMenu(driver);
        leftMenu = new JdiLeftMenu(driver);
    }

    public void openPage() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public void logIn(String username, String password) {
        profilePhoto.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(profilePhoto));
        loginInput.sendKeys(username);
        pswInput.sendKeys(password);
        submitButton.click();
    }

    public String getLoggedUserName() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(loggedUsername));
        if (loggedUsername.isDisplayed()) {
            return loggedUsername.getText();
        } else {
            return "username not displayed";
        }
    }

    public int countBenefitIcons() {
        return benefitsIcons.size();
    }

    public List<String> getBenefitsTexts() {
        return getTextFromVisibleElements(benefitsText);
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

    public JdiHeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public JdiLeftMenu getLeftMenu() {
        return leftMenu;
    }
}
