package com.algorithm;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {

    public void quicksort(int[] nums, int start, int end) {
        if (start >= end) return;
        int q = randomThreeMedianPartition(nums, start, end);
        quicksort(nums, start, q-1);
        quicksort(nums, q+1, end);
    }

    public int randomPartition(int[] nums, int start, int end) {
        Random r = new Random();
        int index = start + r.nextInt(end - start);
        swap(nums, index, end);
        return partition(nums, start, end);
    }

    public int randomThreeMedianPartition(int[] nums, int start, int end) {
        Random r = new Random();
        int index = start + r.nextInt(end - start);
        if (end - start > 3){
            int a = start + r.nextInt(end - start);
            int b = start + r.nextInt(end - start);
            int c = start + r.nextInt(end - start);
            index = nums[a] > nums[b] ? (nums[a] < nums[c] ? a : (nums[b] > nums[c] ? b : c)) : (nums[b] < nums[c] ? b : c);
        }
        swap(nums, index, end);
        return partition(nums, start, end);
    }

    public int partition(int[] nums, int start, int end) {
        int x = nums[end];
        int i = start-1;
        for (int j = start; j <= end-1; j++) {
            if (nums[j] <= x){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, end);
        return i+1;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public void quick3Way(int[] nums, int start, int end) {
        if (end <= start) return;
        int x = nums[start];//这里可以随机选取或者三数取中选取拆分元素
        int lt = start, i = start+1, gt = end;
        while (i <= gt) {
            if (nums[i] < x) swap(nums, lt++, i++);
            else if (nums[i] > x) swap(nums, i, gt--);
            else i++;
        }
        quick3Way(nums, start, lt-1);
        quick3Way(nums, gt+1, end);
    }
}
