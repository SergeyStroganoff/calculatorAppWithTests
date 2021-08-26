package org.stroganov;

import org.stroganov.exeptions.InputExpressionException;

public class StringValidator implements StringValidate {

    public static final String SYNTHESIS_ERROR_STRING = "Ошибка синтаксиса в выражении: ";

    @Override
    public boolean IsStringArithmeticExpression(String s) throws InputExpressionException {
        if (s == null || s.equals("")) {
            throw new InputExpressionException(SYNTHESIS_ERROR_STRING + s);
        }
        return true;
    }
}
