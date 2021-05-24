package ru.training.at.hw7.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JdiLeftMenu extends BasePage {

    @FindBy(xpath = "//*[@class='sidebar-menu left']/child::li")
    List<WebElement> leftMenu;

    public JdiLeftMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getLeftMenuItems() {
        return getTextFromVisibleElements(leftMenu);
    }
}
