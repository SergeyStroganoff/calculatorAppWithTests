package org.stroganov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    String testString;
    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        testString = "10 + 2 * 8 - 3";
        calculator = new Calculator();
    }

    @Test
    public void getPostfixExpression() {
        Assert.assertEquals("10 2 8 * + 3 -", calculator.getPostfixExpression(testString));
    }

    @Test
    public void calculatePostfixExpression() {
        Assert.assertEquals(23, calculator.calculatePostfixExpression(calculator.getPostfixExpression(testString)));
    }
}