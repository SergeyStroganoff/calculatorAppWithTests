package org.stroganov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    String testString = "10 + 2 * 8 - 3";
    Calculator calculator = new Calculator();

    @Before
    public void setUp() throws Exception {

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