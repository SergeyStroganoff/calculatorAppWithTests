package org.stroganov;

import org.stroganov.exeptions.DivisionByZeroException;
import org.stroganov.exeptions.InputExpressionException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.showInputMessage();
        double result;
        Calculator calculator = new Calculator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringValidate stringValidator = new StringValidator();
        StringFormatter stringFormatter = new StringFormatter();
        try {
            String stringFromUser = userInterface.getStringFromUser(reader);
            stringValidator.IsStringArithmeticExpression(stringFromUser);
            String postfixExpression = stringFormatter.getPostfixExpression(stringFromUser);
            result = calculator.calculatePostfixExpression(postfixExpression);
            userInterface.showOutputMessage(result);
        } catch (InputExpressionException | DivisionByZeroException e) {
            userInterface.showErrorMessage(e.getMessage());
        }
    }
}
