package ru.training.at.hw6.site;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.site.forms.LoginForm;
import ru.training.at.hw6.site.pages.HomePage;
import ru.training.at.hw6.site.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {


    public static HomePage homePage;
    public static MetalsColorsPage metalsPage;

    @FindBy(id = "login-form")
    public static LoginForm loginForm;

    @Css(".profile-photo [ui=label]")
    public static UIElement userName;

    @Css("img#user-icon")
    public static UIElement userIcon;

    @Css("ul.uui-navigation.nav.navbar-nav.m-l8")
    public static Menu headerMenu;

}
