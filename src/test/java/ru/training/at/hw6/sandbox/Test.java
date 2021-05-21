package ru.training.at.hw6.sandbox;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ru.training.at.hw6.entities.MetalAndColor;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String... args) throws IOException {
        int[] test1 = {7, 8};
        String[] chk1 = {"Water", "Wind"};
        String[] veget = {"Tomato", "Vegetables", "Onion"};

        MetalAndColor testData = new MetalAndColor(
                test1,
                chk1,
                "Yellow",
                "Gold",
                veget
        );
//        serializeData(testData);
////        List<MetalAndColor> exp = deserialize();
//        exp.forEach(s -> System.out.println(s + "\n\n"));
////        System.out.println(deserialize().toString());

    }

    public static void serializeData(MetalAndColor data) {
        Gson gson = new Gson();
        String json = gson.toJson(data);
        System.out.println(json);
    }


//    public static List<MetalAndColor> deserialize() throws FileNotFoundException {
//        List<MetalAndColor> list = new ArrayList<>();
//        FileReader file_big = new FileReader("src/test/resources/test2.json");
//        Gson gson = new Gson();
//        Type datasets =
//                new TypeToken<HashMap<String, MetalAndColor>>(){}.getType();
//        HashMap<String, MetalAndColor> expected = gson.fromJson(file_big, datasets);
//        for (Map.Entry<String, MetalAndColor> el : expected.entrySet()) {
//            list.add(el.getValue());
//        }
//        return list;
//    }

    public static Object[] deserialize() throws FileNotFoundException {
        List<MetalAndColor> list = new ArrayList<>();
        FileReader file_big = new FileReader("src/test/resources/test2.json");
        Gson gson = new Gson();
        Type datasets =
                new TypeToken<HashMap<String, MetalAndColor>>(){}.getType();
        HashMap<String, MetalAndColor> expected = gson.fromJson(file_big, datasets);
        for (Map.Entry<String, MetalAndColor> el : expected.entrySet()) {
            list.add(el.getValue());
        }
        return list.toArray();
    }
}
