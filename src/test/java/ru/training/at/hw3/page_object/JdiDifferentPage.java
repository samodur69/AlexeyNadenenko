package ru.training.at.hw3.page_object;

import org.openqa.selenium.WebDriver;

public class JdiDifferentPage extends BasePage {

    public JdiDifferentPage() {
        super();
    }

    public void openPage() {
        driver.get(prop.getProperty("TEST_URL"));
    }
}
