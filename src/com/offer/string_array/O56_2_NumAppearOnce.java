package com.offer.string_array;

/**
 * 数组中一个数字只出现一次，其他数字都出现了三次，找出出现一次的数字
 * 算法：位操作
 * 将出现三次的位的每一位按位相加，则每一位肯定可以被3整除，而如果这一位在出现一次的数中也是1
 * 则该位相加的结果不能被3整除
 */
public class O56_2_NumAppearOnce {
    public int findNumAppearOnce(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int result = 0;
        int bitMask = 1;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int j = 0; j < array.length; j++) {
                if ((array[j] & bitMask) != 0) {
                    bitSum++;
                }
            }
            if ((bitSum % 3) != 0) {
                result |= bitMask;
            }
            bitMask <<= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        O56_2_NumAppearOnce test = new O56_2_NumAppearOnce();
        int[] array = {1,2,2,2,3,3,3,5,5,5,6,6,6};
        System.out.print(test.findNumAppearOnce(array));
    }
}
