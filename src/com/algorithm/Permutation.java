package com.algorithm;

import java.util.Set;
import java.util.TreeSet;

public class Permutation {

    public void permutation1(int[] nums, int start) {
        if (start == nums.length - 1) {
            for (int i : nums) {
                System.out.print(i);
            }
            System.out.println("\n");
        }
        for (int i = start; i < nums.length; i++) {
            //swap nums[i] nums[start]
            swap(nums, i, start);
            permutation1(nums, start + 1);
            //swap nums[i] nums[start]
            swap(nums, i, start);
        }
    }

    Set<String> res = new TreeSet<>();
    public void permutation2(int[] nums, int start) {
        if (start == nums.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int i : nums) {
                sb.append(i);
            }
            res.add(sb.toString());
        }
        for (int i = start; i < nums.length; i++) {
            //swap nums[i] nums[start]
            swap(nums, i, start);
            permutation2(nums, start + 1);
            //swap nums[i] nums[start]
            swap(nums, i, start);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        Permutation test = new Permutation();
        test.permutation2(nums, 0);
        System.out.println(test.res);
    }
}
