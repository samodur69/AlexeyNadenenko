package ru.training.at.hw5.pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@Getter
public class JdiUserTable extends BasePage {

    @FindBy (xpath = "//div[@class='main-content']/descendant::select")
    private List<WebElement> numberTypesDropdowns;

    @FindBy (css = "select > option")
    private List<WebElement> dropdownOptions;

    @FindBy (xpath = "//table[@id='user-table']//tr//a")
    private List<WebElement> userNames;

    @FindBy (xpath = "//div[@class='main-content']/descendant::span")
    private List<WebElement> userImageDescriptions;

    @FindBy (xpath = "//div[@class='main-content']/descendant::input")
    private List<WebElement> userCheckboxes;

    @FindBy (xpath = "//table[@id='user-table']/tbody//tr")
    private List<WebElement> tableRows;

    @FindBy (xpath = "//*[@class='panel-body-list logs']/li")
    private List<WebElement> logItems;

    public JdiUserTable(WebDriver driver) {
        super(driver);
    }

    public void selectCheckBoxOnUserTablePage(String username) {
        for (WebElement el : userCheckboxes) {
            el.getText();
            if (username.toLowerCase().contains(el.getAttribute("id"))) {
                el.click();
                break;
            }
        }
    }

    public List<List<String>> parseUserTableForTest() {
        List<List<String>> parsedTableRows = new ArrayList<>();
        for (WebElement element : tableRows) {
            List<WebElement> rowItems = element.findElements(By.tagName("td"));
            List<String> parsedRow = new ArrayList<>();

            parsedRow.add(rowItems.get(0).getText());
            parsedRow.add(rowItems.get(2).getText());
            parsedRow.add(rowItems.get(3)
                    .findElement(By.tagName("span"))
                    .getText()
                    .replace("\n", " "));

            parsedTableRows.add(parsedRow);
        }
        //        parsedTableRows.forEach(s -> System.out.println(s.toString()));
        return parsedTableRows;
    }
}
