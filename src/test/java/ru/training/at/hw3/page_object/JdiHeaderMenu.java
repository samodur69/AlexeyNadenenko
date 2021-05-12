package ru.training.at.hw3.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class JdiHeaderMenu extends BasePage {

    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']/child::li")
    List<WebElement> headerTopLevelMenu;

    @FindBy(linkText = "Service")
    WebElement headerSubMenuOpener;

    @FindBy(xpath = "//*[@class='dropdown-menu']/li")
    List<WebElement> headerSubMenu;



    WebDriver driver;

    public JdiHeaderMenu(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getHeaderMenuItems() {
        return getTextFromVisibleElements(headerTopLevelMenu);
    }


    public void clickHeaderServiceMenuItem(String item) {
        headerSubMenuOpener.click();
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfAllElements(headerSubMenu));
        for (WebElement el : headerSubMenu) {
            if (el.getText().equals(item)) {
                el.click();
            }
        }
    }
}
