package ru.training.at.hw6.sandbox;

import com.google.gson.Gson;
import ru.training.at.hw6.entities.MetalAndColor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String... args) throws IOException {
        String filepath = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
        Gson gson = new Gson();
        FileInputStream file = new FileInputStream(filepath);
        MetalAndColor test = gson.fromJson(
                new InputStreamReader(file), MetalAndColor.class);
        System.out.println(test.toString());
    }
}
