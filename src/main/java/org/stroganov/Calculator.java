package org.stroganov;

import java.util.Stack;

public class Calculator {

    public int calculatePostfixExpression(String postFixString) {
        int calculatedResult;
        Stack<String> stringStack = new Stack<>();
        String[] pastFixExpressionBuffer = postFixString.split(" ");

        for (String nextString : pastFixExpressionBuffer) {
            switch (nextString) {

                case "*": {
                    int first = Integer.parseInt(stringStack.pop());
                    int second = Integer.parseInt(stringStack.pop());
                    int result = first * second;
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "/": {
                    int first = Integer.parseInt(stringStack.pop());
                    int second = Integer.parseInt(stringStack.pop());
                    int result = first / second;
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "+": {
                    int first = Integer.parseInt(stringStack.pop());
                    int second = Integer.parseInt(stringStack.pop());
                    int result = first + second;
                    stringStack.push(String.valueOf(result));
                    break;
                }
                case "-": {
                    int first = Integer.parseInt(stringStack.pop());
                    int second = Integer.parseInt(stringStack.pop());
                    int result = second - first;
                    stringStack.push(String.valueOf(result));
                    break;
                }
                default: {
                    stringStack.push(nextString);
                }
            }
        }
        calculatedResult = Integer.parseInt(stringStack.pop());
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
                        //String stringTopStack = stringStack.peek();
                        //  if (stringTopStack.equals("*") && stringTopStack.equals("/")) {
                        stringBuilder.append(stringStack.pop()).append(" ");
                        //  }
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
