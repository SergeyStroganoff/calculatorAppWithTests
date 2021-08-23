package org.stroganov;

import org.stroganov.exeptions.InputExpressionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    public static final String INPUT_MESSAGE = "Введите арифметическое выражение разделенное пробелами";
    public static final String OUTPUT_MESSAGE = "Результат выражения ";
    public static final String ERROR_MESSAGE = "Вы ввели не валидное выражение ";

    public String getValidExpressionFromUser() throws InputExpressionException {
        String expressionString = " ";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            expressionString = reader.readLine();
            if (!isExpressionValid(expressionString)) {
                throw new InputExpressionException("Ошибка синтаксиса в выражении");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expressionString;
    }

    public boolean isExpressionValid(String expression) {
        return expression != null && !expression.equals("") && !expression.matches("[a-zA-Z]");
    }

    public void showInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public void showOutputMessage(String calculatedString) {
        System.out.println(OUTPUT_MESSAGE + calculatedString);
    }

    public void showErrorMessage(String errorExpression) {
        System.out.println(ERROR_MESSAGE + errorExpression);
    }
}
