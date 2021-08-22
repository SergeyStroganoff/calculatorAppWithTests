package org.stroganov;

public enum Operators {

    MULTIPLICATION("*", 10), DIVISION("/", 10),
    ADDITION("+", 9), SUBTRACTION("-", 9),
    SQUARE_ROOT("sqrt", 10), EXPONENTIATION("^", 10);

    String sign;
    int priority;

    Operators(String sign, int priority) {
        this.sign = sign;
        this.priority = priority;
    }
}
