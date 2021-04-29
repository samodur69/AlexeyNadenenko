package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.DataProviders;

public class CalculatorMultiplyTest {
    Calculator calculator;

    @BeforeClass
    public void calcSetUp() {
        calculator = new Calculator();
    }

    @Test(description = "regular multiply test",
            dataProviderClass = DataProviders.class,
            dataProvider = "regular Long Numbers")
    public void regularLongMultiplyTest(long a, long b) {
        long actual = calculator.mult(a, b);
        long expected = a * b;
        Assert.assertEquals(actual, expected, "incorrect multiply with long numbers");
    }

    @Test(description = "regular multiply test with double numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "multiply double numbers")
    public void regularDoubleMultiplyTest(double a, double b) {
        double actual = calculator.mult(a, b);
        double expected = a * b;
        Assert.assertEquals(actual, expected, 0.000001, "incorrect multiply with double numbers");
    }

    @AfterClass
    public void calcTearDown() {
        calculator = null;
    }
}
