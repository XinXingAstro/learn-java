package com.offer.string_array;

/**
 * 输入一个数组，求所有子数组和的最大值，要求时间复杂度是O(n)
 * 算法：
 * 逐个累加数组中的元素，记录当前累加的最大值，如果和出现复数，则抛弃之前的数
 * 从当前数算起。
 *
 * 问题：
 * 1）怎样进行错误处理？全局变量？返回0？
 */
public class O42_GreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int sum = 0;
        int greatestSum = 0x80000000; //greatestSum要设置为最大的负数
        for (int i = 0; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            if (greatestSum < sum) {
                greatestSum = sum;
            }
        }

        return greatestSum;
    }
}
