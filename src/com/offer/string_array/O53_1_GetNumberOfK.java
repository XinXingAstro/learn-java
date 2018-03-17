package com.offer.string_array;

/**
 * 统计某一数字在排序数组中出现的次数
 * 算法：
 * 用二分法查找第一个k出现的位置，用二分法查找最后一个k出现的位置
 * 返回数字出现的次数
 * 时：O(logn)
 */
public class O53_1_GetNumberOfK {
    public int GetNumberOfK(int[] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);

        if (first > -1 && last > -1) {
            return last - first + 1;
        }
        return 0;
    }

    public int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        int midNum = array[mid];
        if (midNum == k) {
            if ((mid > 0 && array[mid - 1] != midNum) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midNum > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getFirstK(array, k, start, end);
    }

    public int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        int midNum = array[mid];
        if (midNum == k) {
            if ((mid < (array.length - 1) && array[mid + 1] != k) || mid == (array.length - 1)) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midNum > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        O53_1_GetNumberOfK test = new O53_1_GetNumberOfK();
        int[] array = {1,1,1,1,1,1,2,3,3,3,3};
        System.out.print(test.GetNumberOfK(array, 1));
    }
}
