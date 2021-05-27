package ru.training.at.hw6.site.components;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class Results extends Section {
    @UI(".summ-res")
    public static Text summary;

    @UI(".elem-res")
    public static Text elements;

    @UI(".col-res")
    public static Text color;

    @UI(".met-res")
    public static Text metal;

    @UI(".sal-res")
    public static Text vegetables;

    public static int getSummary() {
        return Integer.parseInt(summary.getTextForce().split(": ")[1]);
    }

    public static String getTextElementValue(Text element) {
        return element.getTextForce().split(": ")[1];
    }

    public static String[] getTextElementValuesArray(Text element) {
        return element.getTextForce().split(": ")[1].split(", ");
    }
}
