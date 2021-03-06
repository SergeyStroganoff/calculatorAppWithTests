package org.stroganov;

import java.util.Stack;

public class StringFormatter implements IFormatter {
    @Override
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
