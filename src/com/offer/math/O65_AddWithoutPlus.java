package com.offer.math;

/**
 * 写一个函数，求两个数之和，要求在函数体内不得使用"+"，"-"，"*"，"/"四则运算符号
 * 算法：利用位运算（三步走法）
 * I.两数异或（相当于两数相加不考虑进位）
 * II.两数相与然后左移（相当于只考虑进位）
 * III.重复I.II.直到进位数为0
 */
public class O65_AddWithoutPlus {
    public int Add(int num1,int num2) {
        if (num1 == 0) {
            return num2;
        }
        if (num2 == 0) {
            return num1;
        }
        int n1 = 0;
        int n2 = 0;
        do {
            n1 = num1 ^ num2;
            n2 = (num1 & num2) << 1;
            num1 = n1;
            num2 = n2;
        } while (num2 != 0);

        return num1;
    }
}
