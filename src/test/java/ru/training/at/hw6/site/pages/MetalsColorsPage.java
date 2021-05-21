package ru.training.at.hw6.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw6.site.forms.MetalsAndColorsForm;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {

    @UI(".form")
    public MetalsAndColorsForm form;

//    @UI(".results")
//    public Results results;
}
