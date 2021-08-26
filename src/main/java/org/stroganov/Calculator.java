package org.stroganov;

import org.stroganov.exeptions.DivisionByZeroException;

import java.util.Stack;

public class Calculator {

    public static final String DIVISION_BY_ZERO_STRING = "Попытка деления на ноль числа ";

    public double calculatePostfixExpression(String postFixString) throws DivisionByZeroException {
        Stack<String> stringStack = new Stack<>();
        String[] pastFixExpressionBuffer = postFixString.split(" ");

        for (String nextString : pastFixExpressionBuffer) {
            switch (nextString) {

                case "*": {
                    double first = Double.parseDouble(stringStack.pop());
                    double second = Double.parseDouble(stringStack.pop());
                    double result = multiple(first, second);
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "/": {
                    double first = Double.parseDouble(stringStack.pop());
                    double second = Double.parseDouble(stringStack.pop());
                    double result = division(first, second);
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "+": {
                    double first = Double.parseDouble(stringStack.pop());
                    double second = Double.parseDouble(stringStack.pop());
                    double result = addition(first, second);
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "-": {
                    double first = Double.parseDouble(stringStack.pop());
                    double second = Double.parseDouble(stringStack.pop());
                    double result = subtraction(second, first);
                    stringStack.push(String.valueOf(result));
                    break;
                }
                default: {
                    if (nextString.contains("sqrt")) {
                        double sqrtParameter = Double.parseDouble(nextString.split("sqrt")[1]);
                        nextString = String.valueOf(sqrt(sqrtParameter));
                    }
                    stringStack.push(nextString);
                }
            }
        }
        return Double.parseDouble(stringStack.pop());
    }



    public double multiple(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double division(double firstNumber, double secondNumber) throws DivisionByZeroException {
        if (secondNumber == 0) {
            throw new DivisionByZeroException(DIVISION_BY_ZERO_STRING + firstNumber);
        }
        return firstNumber / secondNumber;
    }

    public double addition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}
