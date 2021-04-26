package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "correct Long Numbers")
    public static Object[][] correctLongNumbers() {
        return new Object[][]{{10000L, 100000L}, {1L, 999L}, {0L, 1L}};
    }

    @DataProvider(name = "max long numbers")
    public static Object[][] maxLongNumbers() {
        return new Object[][]{{9223372036854775807L, 9223372036854775807L}};
    }
}
