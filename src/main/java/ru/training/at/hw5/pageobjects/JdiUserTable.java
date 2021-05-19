package ru.training.at.hw5.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class JdiUserTable extends BasePage {

    @FindBy (xpath = "//div[@class='main-content']/descendant::select")
    private List<WebElement> numberTypesDropdowns;

    @FindBy (xpath = "//table[@id='user-table']//tr//a")
    private List<WebElement> userNames;

    @FindBy (xpath = "//div[@class='main-content']/descendant::span")
    private List<WebElement> userImageDescriptions;

    @FindBy (xpath = "//div[@class='main-content']/descendant::input")
    private List<WebElement> userCheckboxes;

    public JdiUserTable(WebDriver driver) {
        super(driver);
    }
}
