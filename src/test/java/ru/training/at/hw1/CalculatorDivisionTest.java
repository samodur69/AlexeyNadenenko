package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.DataProviders;

public class CalculatorDivisionTest {

    Calculator calculator;

    @BeforeClass
    public void calcSetUp() {
        calculator = new Calculator();
    }

    @Test(description = "regular division test",
            dataProviderClass = DataProviders.class,
            dataProvider = "regular Long Numbers")
    public void regularLongDivTest(long a, long b) {
        long actual = calculator.div(a, b);
        long expected = a / b;
        Assert.assertEquals(actual, expected, "incorrect regular division with long numbers");
    }

    @Test(expectedExceptions = NumberFormatException.class,
            description = "division by Zero test",
            dataProviderClass = DataProviders.class,
            dataProvider = "long numbers for division by zero")
    public void divisionLongByZeroTest(long a, long b) {
        long actual = calculator.div(a, b);
        long expected = a / b;
        Assert.assertEquals(actual, expected, "Wrong division by Zero");
    }

    @Test(description = "zero by number division test",
            dataProvider = "for division zero by long numbers",
            dataProviderClass = DataProviders.class)
    public void zeroByLongDivTest(long a, long b) {
        long actual = calculator.div(a, b);
        long expected = 0;
        Assert.assertEquals(actual, expected, "Incorrect division zero by number");
    }

    @Test(description = "regular division test with double numbers",
            dataProviderClass = DataProviders.class,
            dataProvider = "regular Double Numbers")
    public void regularDoubleDivTest(double a, double b) {
        double actual = calculator.div(a, b);
        double expected = a / b;
        Assert.assertEquals(actual, expected, 0.000001, "incorrect double division");
    }

    @Test(description = "division double by Zero test",
            dataProviderClass = DataProviders.class,
            dataProvider = "double numbers for division by zero")
    public void divisionDoubleByZeroTest(double a, double b) {
        double actual = calculator.div(a, b);
        double expected = a / b;
        Assert.assertEquals(actual, expected, 0.000001, "Wrong division double by Zero");
    }

    @Test(description = "zero by double number division test",
            dataProvider = "for division zero by double numbers",
            dataProviderClass = DataProviders.class)
    public void zeroByDoubleDivTest(double a, double b) {
        double actual = calculator.div(a, b);
        double expected = 0;
        Assert.assertEquals(actual, expected, 0.000001, "Incorrect division zero by double");
    }

    @AfterClass
    public void calcTearDown() {
        calculator = null;
    }
}
