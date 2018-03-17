package com.offer.string_array;

/**
 * 在一个单调递增的数组里每个元素都是整数且是唯一的，找出数组中任意一个数值等于其下标的元素
 * 算法：
 * 由于是单调递增数组，所以可以用二分查找法
 * 如果一个元素的数值小于其下标，由于数组单调递增，所以其前面的所有元素的值也都小于其下标
 * 如果一个元素的数值大于其下标，由于数组单调递增，所以其后面的所有元素的都也都大于其小表
 *
 * 问题：
 * 数组中有没有相等的元素？所有数字都是唯一的所以没有重复数字
 */
public class O53_3_GetNumberSameAsIndex {
    public int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] == mid) {
                return mid;
            } else if (array[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        O53_3_GetNumberSameAsIndex test = new O53_3_GetNumberSameAsIndex();
        int[] array = {0};
        System.out.print(test.getNumberSameAsIndex(array));
    }
}
