package org.stroganov;

import java.util.Stack;

public class Calculator {

    public double calculatePostfixExpression(String postFixString) {
        double calculatedResult;
        Stack<String> stringStack = new Stack<>();
        String[] pastFixExpressionBuffer = postFixString.split(" ");

        for (String nextString : pastFixExpressionBuffer) {
            switch (nextString) {

                case "*": {
                    double first = Double.parseDouble(stringStack.pop());
                    double second = Double.parseDouble(stringStack.pop());
                    double result = first * second;
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "/": {
                    double first = Double.parseDouble(stringStack.pop());
                    double second = Double.parseDouble(stringStack.pop());
                    double result = first / second;
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "+": {
                    double first = Double.parseDouble(stringStack.pop());
                    double second = Double.parseDouble(stringStack.pop());
                    double result = first + second;
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "-": {
                    double first = Double.parseDouble(stringStack.pop());
                    double second = Double.parseDouble(stringStack.pop());
                    double result = second - first;
                    stringStack.push(String.valueOf(result));
                    break;
                }
                default: {
                    if (nextString.contains("sqrt")) {
                        double sqrtParameter = Double.parseDouble(nextString.split("sqrt")[1]);
                        nextString = String.valueOf(Math.sqrt(sqrtParameter));
                    }
                    stringStack.push(nextString);
                }
            }
        }
        calculatedResult = Double.parseDouble(stringStack.pop());
        return calculatedResult;
    }

    public String getPostfixExpression(String expressionString) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stringStack = new Stack<>();
        String[] expressionBuffer = expressionString.split(" ");

        for (String nextString : expressionBuffer) {
            switch (nextString) {
                case ("+"):
                case ("-"): {
                    while (!stringStack.isEmpty()) {
                        stringBuilder.append(stringStack.pop()).append(" ");
                    }
                    stringStack.push(nextString);
                    break;

                }
                case ("*"):
                case ("/"): {
                    stringStack.push(nextString);
                    break;
                }
                default:
                    stringBuilder.append(nextString).append(" ");
            }
        }
        while (!stringStack.isEmpty()) {
            stringBuilder.append(stringStack.pop()).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
