package com.offer.math;

public class O10_Fibonacci {
    public int fibonacci(int n) {
        int fibNMinus1 = 1;
        int fibNMinus2 = 0;
        if (n == 0) {
            return fibNMinus2;
        }
        if (n == 1) {
            return fibNMinus1;
        }
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinus1 + fibNMinus2;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibN;
        }

        return fibN;
    }

    public static void main(String[] args) {
        O10_Fibonacci test = new O10_Fibonacci();
        System.out.println(test.fibonacci(5));
    }
}
