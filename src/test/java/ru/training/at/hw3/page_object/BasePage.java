package ru.training.at.hw3.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw3.Utils.DriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

abstract class BasePage {

    WebDriver driver;
    Properties prop;

    public BasePage() {
        driver = new DriverManager().setupDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean checkTitle(String title) {
        return title.equals(driver.getTitle());
    }

    public static List<String> getTextFromVisibleElements(List<WebElement> elements) {
        List<String> result = new ArrayList<>();
        for (WebElement el : elements) {
            if (el.isDisplayed()) {
                result.add(el.getText());
            }
        }
        return result;
    }
}
