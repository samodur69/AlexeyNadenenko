package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.DataProviders;

public class CalculatorSubTest {

    Calculator calculator;

    @BeforeClass
    public void calcSetUp() {
        calculator = new Calculator();
    }

    @Test(description = "subtraction of two long numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "correct Long Numbers")
    public void regularSubTest(long a, long b) {
        long result = calculator.sub(a, b);
        long expected = a - b;
        Assert.assertEquals(result, expected, "subtraction of two long numbers incorrect");
    }

    @Test(description = "subtraction of two regular double numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "correct Double Numbers")
    public void regularSubTest(double a, double b) {
        double result = calculator.sub(a, b);
        double expected = a - b;
        Assert.assertEquals(result, expected, "sub of two long numbers incorrect");
    }

    @Test(description = "subtraction of two min long numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "min long numbers")
    public void maxLongNumbersSumTest(long a, long b) {
        long result = calculator.sub(a, b);
        long expected = a - b;
        Assert.assertEquals(result, expected, "Sum with memory overflow incorrect");
    }

    @Test(description = "sub of two max double numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "max double numbers")
    public void maxLongNumbersSumTest(double a, double b) {
        double result = calculator.sub(a, b);
        double expected = a - b;
        Assert.assertEquals(result, expected, "Sub with memory overflow incorrect");
    }

    @AfterClass
    public void calcTearDown() {
        calculator = null;
    }

}
