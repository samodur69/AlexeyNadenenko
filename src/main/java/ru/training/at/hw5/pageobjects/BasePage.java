package ru.training.at.hw5.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkTitle(String title) {
        return title.equals(driver.getTitle());
    }

    @Step(value = "Get text from visible web elements.")
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
