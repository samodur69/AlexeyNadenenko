package ru.training.at.hw6.site.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.entities.MetalAndColor;

public class MetalsAndColorsForm extends Form<MetalAndColor> {
    @UI("[name =custom_radio_odd]")
    public RadioButtons odd;

    @UI("[name =custom_radio_even]")
    public RadioButtons even;

    @UI("#elements-checklist input[type=checkbox]")
    public Checklist checkboxElements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metal;

    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown vegetables;

    @UI("#submit-button")
    public Button submitButton;

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “submit” <br>
     */
    @Override
    public void submit(MetalAndColor entity) {
        odd.select(entity.getOdd());
        even.select(entity.getEven());
        checkboxElements.select(entity.getCheckboxElements());
        colors.select(entity.getColor());
        metal.select(entity.getMetal());
        vegetables.select("Vegetables");
        vegetables.select(entity.getVegetables());
        submitButton.click();
    }
}
