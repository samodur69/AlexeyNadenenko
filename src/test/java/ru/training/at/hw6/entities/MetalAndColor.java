package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class MetalAndColor extends DataClass<MetalAndColor> {

    int[] summary;
    String[] elements;
    String color;
    String metals;
    String[] vegetables;

    public MetalAndColor() {
    }

    public MetalAndColor(int[] summary,
                         String[] elements,
                         String color,
                         String metal,
                         String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metal;
        this.vegetables = vegetables;
    }

    static int[] test1 = {7, 8};
    static String[] chk1 = {"Water", "Wind"};
    static String[] veget = {"Tomato", "Vegetables", "Onion"};

    public static MetalAndColor testEntity = new MetalAndColor(test1,
            chk1,
            "Yellow",
            "Gold",
            veget);

//    @Override
//    public String toString() {
//        return String
//                .format("radio: %s %s"
//                        + "\nColor: %s"
//                        + "\nMetal: %s", radio[0], radio[1], color, metal);
//    }


    @Override
    public String toString() {
        return "MetalAndColor{"
                + "\nradio=" + Arrays.toString(summary)
                + ", \ncheckboxElements=" + Arrays.toString(elements)
                + ", \ncolor='" + color + '\''
                + ", \nmetal='" + metals + '\''
                + ", \nvegetables=" + Arrays.toString(vegetables)
                + '}';
    }
}
