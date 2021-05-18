package ru.training.at.hw5.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class JdiDifferentPage extends BasePage {

    @FindBy(className = "label-checkbox")
    List<WebElement> checkBoxes;

    @FindBy(className = "label-radio")
    List<WebElement> radioBoxes;

    @FindBy(xpath = "//*[@class='colors']/select")
    WebElement colorSelect;

    @FindBy(xpath = "//*[@class='panel-body-list logs']/li")
    List<WebElement> logItems;

    WebDriver driver;

    public JdiDifferentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(checkBoxes));
        PageFactory.initElements(driver, this);
    }

    @Step(value = "Get title of current page ")
    public String getTitleOfPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleIs("Different Elements"));
        return driver.getTitle();
    }

    @Step(value = "Select checkbox {item}")
    public JdiDifferentPage checkBoxSelect(String item) {
        for (WebElement el : checkBoxes) {
            if (el.getText().equals(item)) {
                el.click();
            }
        }
        return this;
    }

    @Step(value = "Select Radio box {item}")
    public void radioSelect(String item) {
        for (WebElement el : radioBoxes) {
            if (el.getText().equals(item)) {
                el.click();
            }
        }
    }

    @Step(value = "Select {item} from dropdown selector")
    public void dropdownColorSelect(String item) {
        Select colors = new Select(colorSelect);
        colors.selectByVisibleText(item);
    }

    @Step(value = "Get log items from page block")
    public List<String> getLogItems() {
        List<String> log = new ArrayList<>();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(logItems));
        for (WebElement el : logItems) {
            log.add(el.getText());
        }
        return log;
    }
}
