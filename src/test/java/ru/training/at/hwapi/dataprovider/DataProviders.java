package ru.training.at.hwapi.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] boardName() {
        return new Object[][] {{"TestBoardADA"}};
    }

    @DataProvider
    public static Object[][] boardDescription() {
        return new Object[][] {{"TestBoard Description"}};
    }
}
