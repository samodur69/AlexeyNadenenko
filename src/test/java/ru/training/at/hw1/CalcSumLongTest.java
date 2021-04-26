package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalcSumLongTest {

    Calculator calculator;

    @BeforeClass
    public void calcSetUp() {
        calculator = new Calculator();
    }

    @Test(description = "sum of two long numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "correct Long Numbers")
    public void positiveSumTest(long a, long b) {
        long result = calculator.sum(a, b);
        long expected = a + b;
        Assert.assertEquals(result, expected, "sum of two long numbers incorrect");
    }

    @Test(description = "sum of two max long numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "max long numbers")
    public void negativeSumTest(long a, long b) {
        long result = calculator.sum(a, b);
        long expected = -2;
        Assert.assertEquals(result, expected, "Sum with memory overflow incorrect");
    }

    @AfterClass
    public void calcTearDown() {
        calculator = null;
    }
}
