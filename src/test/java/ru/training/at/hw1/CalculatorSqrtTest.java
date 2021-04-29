package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.DataProviders;

public class CalculatorSqrtTest {

    Calculator calculator;

    @BeforeClass
    public void calcSetUp() {
        calculator = new Calculator();
    }

    @Test(description = "sqrt test",
            dataProviderClass = DataProviders.class,
            dataProvider = "sqrt double numbers")
    public void sqrtTest(double a) {
        double result = calculator.sqrt(a);
        double expected = Math.sqrt(a);
        Assert.assertEquals(result, expected, 0.000001, "sqrt func incorrect");
    }

    @AfterClass
    public void calcTearDown() {
        calculator = null;
    }
}
