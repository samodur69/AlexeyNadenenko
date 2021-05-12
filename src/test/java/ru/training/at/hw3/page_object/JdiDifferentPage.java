package ru.training.at.hw3.page_object;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JdiDifferentPage extends BasePage {

    @FindBy(xpath = "//*[@class='label-checkbox']/input")
    List<WebElement> checkBoxes;

    @FindBy
    List<WebElement> radioBoxes;

    @FindBy
    List<WebElement> logItems;

    private JdiHeaderMenu headerMenu;
    private JdiLeftMenu leftMenu;

    public JdiDifferentPage() {
        super();
        headerMenu = new JdiHeaderMenu(driver);
        leftMenu = new JdiLeftMenu(driver);
    }

    public boolean isLoaded() {
        return driver.getTitle().equals("Different Elements");
    }

    public boolean checkBoxSelect(String item) {
        for (WebElement el : checkBoxes) {
            if (el.getText().equals(item)) {
                el.click();
                return el.isSelected();
            }
        }
        return false;
    }


}
