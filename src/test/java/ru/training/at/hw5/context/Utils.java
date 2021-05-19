package ru.training.at.hw5.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> generateRegex(Map<String, String> expected) {
        List<String> regExp = new ArrayList<>();
        expected.forEach((key, value) -> {
            String regex = ".*(" + key + ").*(" + value + ")";
            regExp.add(regex);
        });
        // skip fist element because it is table header
        return regExp.stream().skip(1).collect(Collectors.toList());
    }
}
