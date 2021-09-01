package org.stroganov;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.stroganov.exeptions.InputExpressionException;

@RunWith(MockitoJUnitRunner.class)
public class StringValidatorTest {

    @InjectMocks
    StringValidator stringValidator;

    @Test(expected = InputExpressionException.class)
    public void isStringArithmeticExpression_EmptyString_TrowError() throws InputExpressionException {
        //GIVEN
        String testString = "";
        // WHEN
        boolean test = stringValidator.isStringArithmeticExpression(testString);
        //THEN Throw Exception
    }
}