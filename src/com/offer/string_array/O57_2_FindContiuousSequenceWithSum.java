package com.offer.string_array;

import java.util.ArrayList;

/**
 * 输入一个整数s，打印出所有和为s的连续正数序列
 * 算法：
 * 定义两个指针p1，p2，p1初始指向1，p2初始指向2，如果p1到p2内部序列的和小于s，则p2向后移动，
 * 如果内部序列的和大于s，则p1向前移动
 * 由于序列至少有两个数字，所以循环结束条件为p1指向(s+1)/2的位置
 */
public class O57_2_FindContiuousSequenceWithSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int start = 1;
        int end = 2;
        int s = 3;
        int mid = (s + 1) >> 1;
        while (start < end && start < mid) {
            if (s == sum) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int i = start; i <= end; i++) {
                    temp.add(i);
                }
                result.add(temp);
                end++;
                s += end;
                mid = (s + 1) >> 1;
            } else if (s < sum) {
                end++;
                s += end;
                mid = (s + 1) >> 1;
            } else {
                s -= start;
                start++;
                mid = (s + 1) >> 1;
            }
        }
        return result;
    }
}
