package org.stroganov;

import org.stroganov.exeptions.InputExpressionException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.showInputMessage();
        double result;
        Calculator calculator = new Calculator();
        try {
            String postfixExpression = calculator.getPostfixExpression(userInterface.getValidExpressionFromUser());
            result = calculator.calculatePostfixExpression(postfixExpression);
            userInterface.showOutputMessage(result);
        } catch (InputExpressionException e) {
            userInterface.showErrorMessage(e.getMessage());
        }
    }
}
