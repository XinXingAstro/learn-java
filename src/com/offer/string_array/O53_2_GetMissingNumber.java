package com.offer.string_array;

/**
 * 在长度为n-1的递增排序数组中的所有数字都是唯一的，每个数字的范围是0～n-1，在0～n-1这n个数中有且只有一个数字不在该数组中，找出这个数字
 * 算法：
 * 由于是递增数组，所以可以用二分查找算法
 * 由于数据的范围是0～n-1，所以假设，第m个数字是缺失数字，则0～m-1的每个数字的数值都应该和下标相等，从第m个数字开始，
 * 后面的数字都要比对应下标大一
 */
public class O53_2_GetMissingNumber {
    public int getMissingNumber(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] == (mid + 1)) {
                if (mid == 0 || array[mid - 1] == (mid - 1)) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        if (start == array.length) {
            return array.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        O53_2_GetMissingNumber test = new O53_2_GetMissingNumber();
        int[] array = {1};
        System.out.print(test.getMissingNumber(array));
    }
}
