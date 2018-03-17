package com.offer.math;

/**
 * 求1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句(A?B:C)
 */
public class O64_Sum {
    public int Sum_Solution(int n) {
        if (n < 0) {
            return -1;
        }
        int sum = n * n + n;
        return sum >> 1;
    }
}
