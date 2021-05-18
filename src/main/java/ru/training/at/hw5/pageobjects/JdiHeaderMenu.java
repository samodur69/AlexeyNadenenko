package ru.training.at.hw5.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

public class JdiHeaderMenu extends BasePage {

    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']/child::li")
    List<WebElement> headerTopLevelMenu;

    //    @FindBy(linkText = "SERVICE")
    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    WebElement headerSubMenuOpener;

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
        headerSubMenuOpener.click();
        //        for (WebElement el : headerTopLevelMenu) {
        //            if (el.getText().equals(menuItem)) {
        //                el.click();
        //                break;
        //            }
        //        }
    }

    public void clickHeaderSubMenu(String item) {
        for (WebElement el : headerSubMenu) {
            System.out.println(el.getText());
            if (el.getText().equals(item.toUpperCase(Locale.ROOT))) {
                el.click();
                break;
            }
        }
    }

//    public void clickHeaderServiceMenuItem(String item) {
//        headerSubMenuOpener.click();
//        headerSubMenu.forEach(s -> System.out.println(s.getText()));
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfAllElements(headerSubMenu));
//        for (WebElement el : headerSubMenu) {
//            if (el.getText().equals(item.toUpperCase(Locale.ROOT))) {
//                el.click();
//                break;
//            }
//        }
//    }

//    public List<String> getHeaderMenuItems() {
//        return getTextFromVisibleElements(headerTopLevelMenu);
//    }
//
//    @Step(value = "Click in header to {item} menu item")
//    public void clickHeaderServiceMenuItem(String item) {
//        headerSubMenuOpener.click();
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfAllElements(headerSubMenu));
//        for (WebElement el : headerSubMenu) {
//            if (el.getText().equals(item)) {
//                el.click();
//                break;
//            }
//        }
//    }
}
