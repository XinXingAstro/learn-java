package com.leetcode.myCode;

import java.util.Arrays;

public class Permutation_Rec {
    //chr为待全排列数组，start表示数组开始位置
    public void permutation(int[] nums, int start) {
        if (start == nums.length - 1) {
            System.out.println(Arrays.toString(nums));
        }
        for (int i = start; i < nums.length; i++) {
            //排列之前进行判断，如果是后面出现相同元素，就不进行交换
            if (i == start || nums[i] != nums[start]) {
                swap(nums, i, start); //把第一个元素分别与后面的元素进行交换
                permutation(nums, start + 1); //递归调用其子数组进行排序
                swap(nums, i, start); //子数组排序返回后要将第一个元素交换回来
                //如第一次'a', 'b'交换，子数组排序返回后如果不将'a', 'b'交换回来，第二次交换的时候就会将'b', 'c'交换
                //因此必须将'a'还原在第一个位置上
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Permutation_Rec test = new Permutation_Rec();
        int[] nums = {1,2,3};
        test.permutation(nums, 0);
    }
}
