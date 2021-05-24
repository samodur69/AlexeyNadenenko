package ru.training.at.hw6.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import ru.training.at.hw6.entities.MetalAndColor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class TestData {

    @DataProvider(name = "jsonData")
    public static Object[][] parseJsonDataset() {
        Gson gson = new Gson();
        List<MetalAndColor> testData = new ArrayList<>();
        FileReader file = null;
        try {
            file =
                    //                    new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json");
                    new FileReader("src/test/resources/onedata.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type datasets =
                new TypeToken<HashMap<String, MetalAndColor>>() {
                }.getType();
        HashMap<String, MetalAndColor> expected = gson.fromJson(file, datasets);
        for (Map.Entry<String, MetalAndColor> el : expected.entrySet()) {
            testData.add(el.getValue());
        }
        return testData
                .stream()
                .map(metalAndColor -> new Object[]{metalAndColor})
                .toArray(Object[][]::new);
    }
}
