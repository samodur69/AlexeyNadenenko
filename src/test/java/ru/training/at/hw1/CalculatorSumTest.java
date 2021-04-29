package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.DataProviders;

public class CalculatorSumTest {

    Calculator calculator;

    @BeforeClass
    public void calcSetUp() {
        calculator = new Calculator();
    }

    @Test(description = "sum of two long numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "regular Long Numbers")
    public void regularLongSumTest(long a, long b) {
        long result = calculator.sum(a, b);
        long expected = a + b;
        Assert.assertEquals(result, expected, "sum of two long numbers incorrect");
    }

    @Test(description = "sum of two regular double numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "regular Double Numbers")
    public void regularDoubleSumTest(double a, double b) {
        double result = calculator.sum(a, b);
        double expected = a + b;
        Assert.assertEquals(result, expected, 0.000001, "sum of two double numbers incorrect");
    }

    @Test(description = "sum of two max long numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "max long numbers")
    public void maxLongNumbersSumTest(long a, long b) {
        long result = calculator.sum(a, b);
        long expected = -2;
        Assert.assertEquals(result, expected, "Sum with memory overflow incorrect");
    }

    @Test(description = "sum of two max double numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "max double numbers")
    public void maxDoubleNumbersSumTest(double a, double b) {
        double result = calculator.sum(a, b);
        double expected = a + b;
        Assert.assertEquals(result, expected, 0.000001, "Sum with memory overflow incorrect");
    }

    @AfterClass
    public void calcTearDown() {
        calculator = null;
    }
}
