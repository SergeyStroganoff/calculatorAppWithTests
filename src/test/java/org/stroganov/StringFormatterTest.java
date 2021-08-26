package org.stroganov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringFormatterTest {
    @InjectMocks
    StringFormatter stringFormatter;

    @Test
    public void getPostfixExpressionTest() {
        //GIVEN
        String expected = "10 2 8 * + 3 -";
        String testString = "10 + 2 * 8 - 3";
        // WHEN
        String actual = stringFormatter.getPostfixExpression(testString);
        //THEN
        Assert.assertEquals(expected, actual);
    }
}