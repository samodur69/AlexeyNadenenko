package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "correct Long Numbers", parallel = true)
    public static Object[][] correctLongNumbers() {
        return new Object[][]{{1000L, 10000L}, {-1L, 9999999999L}, {-20L, -10L}, {10, 5}, {33, 11}};
    }

    @DataProvider(name = "correct Double Numbers", parallel = true)
    public static Object[][] correctDoubleNumbers() {
        return new Object[][]{{2.5, 2.1}, {4.9e-324, 3}, {-3.333333333, -3.333333333333}};
    }

    @DataProvider(name = "max long numbers", parallel = true)
    public static Object[][] maxLongNumbers() {
        return new Object[][]{{9223372036854775807L, -9223372036854775808L}};
    }

    @DataProvider(name = "max double numbers", parallel = true)
    public static Object[][] maxDoubleNumbers() {
        return new Object[][]{{4.9e-324, 1.7e+308}};
    }

    @DataProvider(name = "long numbers for division by zero")
    public static Object[][] longForDivisionByZero() {
        return new Object[][]{{45L, 0L}, {-9223372036854775808L, 0L}, {0L, 0L}};
    }

    @DataProvider(name = "for division zero by long numbers")
    public static Object[][] longForDivisionZero() {
        return new Object[][]{{0L, 9223372036854775807L}, {0L, 1L}};
    }

    @DataProvider(name = "double numbers for division by zero")
    public static Object[][] doubleForDivisionByZero() {
        return new Object[][]{{3.3333, 0}, {1.7e+308, 0}, {0, 0}};
    }

    @DataProvider(name = "for division zero by double numbers")
    public static Object[][] doubleForDivisionZero() {
        return new Object[][]{{0, 1}, {0, 1.7e+308}};
    }
}
