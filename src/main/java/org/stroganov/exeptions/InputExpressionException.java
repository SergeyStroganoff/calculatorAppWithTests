package org.stroganov.exeptions;

public class InputExpressionException extends Exception {


    public InputExpressionException(String message) {
        super(message);
    }

    public InputExpressionException(String message, Throwable cause) {
        super(message, cause);
    }
}
