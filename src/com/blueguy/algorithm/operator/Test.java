package com.blueguy.algorithm.operator;

public class Test {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //算数运算符
        calculator.execute("+", 1, 2);
        calculator.execute("-", 1, 2);
        calculator.execute("*", 1, 6);
        calculator.execute("/", 8, 2);
        calculator.execute("%", 8, 3);
        //位运算符
        calculator.execute("&", 1, 2);
        calculator.execute("|", 1, 2);
        calculator.execute("^", 1, 2);
        calculator.execute(">>", 16, 2);
        calculator.execute("<<", 2, 2);



        System.err.println("===============================");

        int a = 60; /* 60 = 0011 1100 */
        int b = 13; /* 13 = 0000 1101 */
        int c;
        c = a & b;       /* 12 = 0000 1100 */
        System.err.println("a & b = " + c );

        c = a | b;       /* 61 = 0011 1101 */
        System.err.println("a | b = " + c );

        c = a ^ b;       /* 49 = 0011 0001 */
        System.err.println("a ^ b = " + c );

        c = ~a;          /*-61 = 1100 0011 */
        System.err.println("~a = " + c );

        c = a << 2;     /* 240 = 1111 0000 */
        System.err.println("a << 2 = " + c );

        c = a >> 2;     /* 15 = 1111 */
        System.err.println("a >> 2  = " + c );

        c = a >>> 2;     /* 15 = 0000 1111 */
        System.err.println("a >>> 2 = " + c );
    }
}
