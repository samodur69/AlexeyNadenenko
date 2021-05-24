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
