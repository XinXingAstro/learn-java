package com.offer.string_array;

/**
 * 一个整型数组中只出现一次的数有两个，其他数都出现里2次，找出这两个只出现一次的数
 * 算法：利用异或运算解决
 * 由于两个相同的数异或是0，如果数组中只有一个出现一次的数，则对数组中所有数字求异或，最后的结果就是这个数
 * 由于数组中有两个出现一次的数，需要将这两个数分别分到两个子数组中
 * 对数组中所有数求异或，得到的结果是这两个数的异或，我们利用他们第一位不同的数字，来对原数组分组，这样得到
 * 的两个子数组中就分别有一个只出现一次的数，其他数都出现两次
 */
public class O56_1_NumAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res ^= array[i];
        }
        int first1 = findFirst1(res);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & first1) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
    public int findFirst1(int num) {
        int n = 1;
        while ((n & num) == 0) {
            n <<= 1;
        }
        return n;
    }
}
