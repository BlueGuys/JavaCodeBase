package com.blueguy.algorithm.operator;

public class Calculator {

    void execute(String operator, int a, int b) {
        int result = -1;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "%":
                result = a % b;
                break;
            case "&":
                result = a & b;
                break;
            case "|":
                result = a | b;
                break;
            case "^":
                result = a ^ b;
                break;
            case "<<":
                result = a << b;
                break;
            case ">>":
                result = a >> b;
                break;
            default:
                break;
        }
        System.err.println(a + operator + b + "=" + result);
    }
}
