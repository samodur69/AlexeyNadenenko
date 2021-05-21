package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetalAndColor extends DataClass<MetalAndColor> {

    String even;
    String odd;
    String[] checkboxElements;
    String color;
    String metal;
    String[] vegetables;

    public MetalAndColor(int[] radio,
                         String[] checkboxElements,
                         String color,
                         String metal,
                         String[] vegetables) {
        this.odd = "" + radio[0];
        this.even = "" + radio[1];
        this.checkboxElements = checkboxElements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    static int[] test1 = {7, 8};
    static String[] chk1 = {"Water", "Wind"};
    static String[] veget = {"Tomato", "Vegetables", "Onion"};

    public static MetalAndColor testdata = new MetalAndColor(test1,
            chk1,
            "Yellow",
            "Gold",
            veget);

    @Override
    public String toString() {
        return String
                .format("radio: %s %s"
                        + "\nColor: %s"
                        + "\nMetal: %s", even, odd, color, metal);
    }



}
