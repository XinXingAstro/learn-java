package com.offer.string_array;

import java.util.ArrayList;

/**
 * 输入一个递增排序数组和一个数字s，在数组中查找两个数，使他们的和正好是s，如果有
 * 多对数的和等于s，输出两个数的乘机最小的
 * 算法：
 * 定义两个指针，一个指向数组开头，一个指向数组结尾，如果两数的和大于s，则尾指针向
 * 前移动，如果两数之和小于s，头指针向前移动，循环结束条件，头指针小于尾指针
 */
public class O57_1_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        int start = 0;
        int end = array.length - 1;
        int mul = array[end] * array[end];
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (start < end) {
            int a = array[start];
            int b = array[end];
            if ((a + b) == sum) {
                if ((a * b) < mul) {
                    mul = a * b;
                    result.clear();
                    result.add(a);
                    result.add(b);
                }
                start++;
            } else if ((a + b) < sum) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
