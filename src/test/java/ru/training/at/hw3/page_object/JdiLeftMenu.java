package ru.training.at.hw3.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JdiLeftMenu extends BasePage {

    @FindBy(xpath = "//*[@class='sidebar-menu left']/child::li")
    List<WebElement> leftMenu;

    WebDriver driver;

    public JdiLeftMenu(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getLeftMenuItems() {
        return getTextFromVisibleElements(leftMenu);
    }
}
