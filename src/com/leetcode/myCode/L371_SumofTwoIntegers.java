package com.leetcode.myCode;

public class L371_SumofTwoIntegers {
    public int getSum1(int a, int b) {
        int carry;
        while(b != 0) {
            carry = (a & b) << 1;
            a = (a ^ b);
            b = carry;
        }
        return a;
    }
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }
    public int getSubtract(int a, int b) {
        int carry, B = (~b) + 1;
        while(B != 0) {
            carry = (a & B) << 1;
            a = (a ^ B);
            B = carry;
        }
        return a;
    }
    public int getSubtract1(int a, int b) {
        return (b == 0) ? a : getSubtract1(a ^ b, (~a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new L371_SumofTwoIntegers().getSubtract(3, 4));
    }
}
