package org.stroganov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.stroganov.exeptions.DivisionByZeroException;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    String testString;
    @InjectMocks
    Calculator calculator;


    @Before
    public void setUp() throws Exception {
        testString = "10 + 2 * 8 - 3";
    }



    @Test
    public void calculatePostfixExpressionTest() throws DivisionByZeroException {
        //GIVEN
        double expected = 23;
        String inputString = "10 2 8 * + 3 -";
        // WHEN
        double actual = calculator.calculatePostfixExpression(inputString);
        //THEN
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void multipleTwoDoubleNumbersTest() {
        //GIVEN
        double expected = 100;
        // WHEN
        double actual = calculator.multiple(10, 10);
        //THEN
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void divisionTwoDoubleNumbersTest() throws DivisionByZeroException {
        //GIVEN
        double expected = 2;
        // WHEN
        double actual = calculator.division(20, 10);
        //THEN
        Assert.assertEquals(2, calculator.division(20, 10), 0.0001);
    }

    @Test(expected = DivisionByZeroException.class)
    public void divisionByZero_Throws_DivisionByZeroException_Test() throws DivisionByZeroException {
        // WHEN
        double actual = calculator.division(20, 0);
        //THEN trow DivisionByZeroException()
    }

    @Test
    public void addition_ReturnSUM_Two_Number_Test() {
        //GIVEN
        double expected = 24;
        // WHEN
        double actual = calculator.addition(12, 12);
        //THEN
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void subtraction_Return_Subtraction_TWO_Numbers_Test() {
        //GIVEN
        double expected = 0;
        // WHEN
        double actual = calculator.subtraction(12, 12);
        //THEN
        Assert.assertEquals(expected, actual, 0.0001);

    }
}