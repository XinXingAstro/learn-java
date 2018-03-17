package com.offer.bit_manipulation;

/**
 * 计算一个整数的二进制表示中1的个数
 * 两种算法：
 * 1.逐位判断法
 * 2.减1用&法
 */
public class O15_NumberOf1 {
    public int NumberOf1_1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0) {
            if((n & flag) != 0 ) {
                count++;
            }
            flag = flag << 1;
        }

        return count;
    }

    public int NumberOf1_2(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }

    public static void main(String[] args) {
        O15_NumberOf1 test = new O15_NumberOf1();
        System.out.println(test.NumberOf1_1(-1));
        System.out.println(test.NumberOf1_2(1));
    }
}
