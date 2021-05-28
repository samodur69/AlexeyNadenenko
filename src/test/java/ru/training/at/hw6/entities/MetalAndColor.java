package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

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
}
