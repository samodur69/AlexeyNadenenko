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

    @Test (description = "sum of two long numbers")
    public void positiveSumTest() {
        long result = calculator.sum(10000L, 100000L);
        long expected = 110000L;
        Assert.assertEquals(result, expected, "sum of two long numbers incorrect");
    }

    @AfterClass
    public void calcTearDown() {
        calculator = null;
    }
}
