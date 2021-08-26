package org.stroganov;

import org.stroganov.exeptions.InputExpressionException;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInterface {

    public static final String INPUT_MESSAGE = "Введите арифметическое выражение разделенное пробелами";
    public static final String OUTPUT_MESSAGE = "Результат выражения ";
    public static final String ERROR_MESSAGE = "Вы ввели не валидное выражение ";

    public String getStringFromUser(BufferedReader reader) {
        String expressionString = " ";
        try {
            expressionString = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return expressionString;
    }


    public void showInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public void showOutputMessage(double calculatedString) {
        System.out.println(OUTPUT_MESSAGE + calculatedString);
    }

    public void showErrorMessage(String errorExpression) {
        System.out.println(ERROR_MESSAGE + errorExpression);
    }
}
