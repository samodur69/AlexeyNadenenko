package ru.training.at.hw3;

import java.util.Arrays;
import java.util.List;

public class JdiTestData {

    public static final String TESTING_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String TEST_LOGIN = "Roman";
    public static final String TEST_PSW = "Jdi1234";
    public static final String TEST_USERNAME = "ROMAN IOVLEV";

    public static final String MENU_ITEM_0 = "Home";
    public static final String MENU_ITEM_1 = "Contact form";
    public static final String MENU_ITEM_2 = "Service";
    public static final String MENU_ITEM_3 = "Metals & Colors";
    public static final String MENU_ITEM_4 = "Elements packs";


    public static final String BENEFIT_0 = "To include good "
            + "practices\nand ideas from successful\nEPAM project";
    public static final String BENEFIT_1 = "To be flexible and\ncustomizable";
    public static final String BENEFIT_2 = "To be multiplatform";
    public static final String BENEFIT_3 = "Already have good base\n(about 20 internal and\n"
            + "some external projects),\nwish to get more…";

    public static List<String> benefits = Arrays.asList(BENEFIT_0, BENEFIT_1, BENEFIT_2, BENEFIT_3);
    public static List<String> headerMenu = Arrays
            .asList(MENU_ITEM_0, MENU_ITEM_1, MENU_ITEM_2, MENU_ITEM_3);
    public static List<String> leftMenu = Arrays
            .asList(MENU_ITEM_0, MENU_ITEM_1, MENU_ITEM_2, MENU_ITEM_3, MENU_ITEM_4);

    public static String LOG_YELLOW = "";

}
