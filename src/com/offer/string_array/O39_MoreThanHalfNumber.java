package com.offer.string_array;

/**
 * 数组中出现次数超过一半的数
 *
 * 算法1：如果对数组排序，则数组n/2位置上的数就是数组中出现次数超过一半的数
 * 快排算法的partition函数每次确定数组中一个元素的最终位置，只要点用partition
 * 函数找到最终位置在n/2上面数即可
 *
 * 算法2：原理类似计数排序
 * 由于数组中有一个数出现的次数比其他数出现的次数加起来都多，所以我们记录两个值，
 * 一个是数组中某个数，一个是出现的次数，
 * 如果遍历到的数和当前数相等，则次数加一
 * 如果不等，次数减一
 * 如果次数减到0，则设置这个数为当前数，并将此时设为1
 * 我们要找的数，就是最后将次数设为1的那个数
 *
 * 原理：数组中存在两种数，一种相同数
 */
public class O39_MoreThanHalfNumber {
    /**
     * 算法1：应用快排的partition函数找到排序后最终位置在n/2的数
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = array.length >> 1;
        int index = partition(array, start, end);
        while (index != mid) {
            if (index < mid) {
                start = index + 1;
                index = partition(array, start, end);
            } else {
                end = index - 1;
                index = partition(array, start, end);
            }
        }
        int result = array[mid];
        if (!checkHalf(array, result)) {
            return 0;
        }
        return result;
    }

    public int partition(int[] array, int start, int end) {
        int index = start + (int)(Math.random()*(end - start + 1));
        swap(array, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (array[index] < array[end]) {
                small++;
                swap(array, small, index);
            }
        }
        small++;
        swap(array, small, end);

        return small;
    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //检测target出现的次数是否超过了数组的一半
    public boolean checkHalf(int[] array, int target) {
        int time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                time++;
            }
        }
        if (time > (array.length >> 1)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 算法2：由于数组中某一数字出现的次数比其他数字加起来都多，
     * 所以我们从前到后遍历该数组，记录当前数出现的次数，如果
     * 后面一个数和当前数相同，则time++，如果不同则time--，当
     * time减到0的时候，我们将result设置为当前数，然后将time设置为1
     * 我们要找的数，肯定是最后依次将time设为1得数。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_2(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int result = array[0];
        int time = 1;
        for (int i = 1; i < array.length; i++) {
            if (time == 0) {
                result = array[i];
                time = 1;
            } else if (result == array[i]) {
                time++;
            } else {
                time--;
            }
        }
        if (!checkHalf(array, result)) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        O39_MoreThanHalfNumber test = new O39_MoreThanHalfNumber();
        int[] array = {2,1,1,1,1,1,2,4,5};
        System.out.println(test.MoreThanHalfNum_Solution_2(array));
    }
}
