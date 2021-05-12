package ru.training.at.hw3.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw3.DriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

abstract class BasePage {

    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']/child::li")
    List<WebElement> headerMenu;

    WebDriver driver;
    Properties prop;

    public BasePage() {
        driver = DriverManager.setupDriver();
        PageFactory.initElements(driver, this);
        try {
            FileInputStream fi = new FileInputStream("src/test/java/ru/training/at/hw3/testData.properties");
            prop = new Properties();
            prop.load(fi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkTitle(String title) {
        return title.equals(driver.getTitle());
    }

}
