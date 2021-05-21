package ru.training.at.hw5.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Locale;

public class JdiHeaderMenu extends BasePage {

    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']/child::li")
    List<WebElement> headerTopLevelMenu;

    @FindBy(xpath = "//*[@class='dropdown-menu']/child::li")
    List<WebElement> headerSubMenu;

    WebDriver driver;

    public JdiHeaderMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickHeaderMenuButton(String menuItem) {
        //        headerSubMenuOpener.click();
        for (WebElement el : headerTopLevelMenu) {
            if (el.getText().equals(menuItem.toUpperCase(Locale.ROOT))) {
                el.click();
                break;
            }
        }
    }

    public void clickHeaderSubMenu(String item) {
        for (WebElement el : headerSubMenu) {
            if (el.getText().equals(item.toUpperCase(Locale.ROOT))) {
                el.click();
                break;
            }
        }
    }
}
