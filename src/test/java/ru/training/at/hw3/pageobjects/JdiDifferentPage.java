package ru.training.at.hw3.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    public JdiDifferentPage() {
        super();
    }

    public String getTitleOfPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleIs("Different Elements"));
        return driver.getTitle();
    }

    public void checkBoxSelect(String item) {
        for (WebElement el : checkBoxes) {
            if (el.getText().equals(item)) {
                el.click();
            }
        }
    }

    public void radioSelect(String item) {
        for (WebElement el : radioBoxes) {
            if (el.getText().equals(item)) {
                el.click();
            }
        }
    }

    public void dropdownColorSelect(String item) {
        Select colors = new Select(colorSelect);
        colors.selectByVisibleText(item);
    }

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
