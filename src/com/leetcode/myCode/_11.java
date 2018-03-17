package com.leetcode.myCode;

public class _11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int volume = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                volume = (volume < (j - i) * height[i]) ? (j - i) * height[i] : volume;
                i++;
            } else {
                volume = (volume < (j - i) * height[j]) ? (j - i) * height[j] : volume;
                j--;
            }
        }
        return volume;
    }
    public static void main(String[] args) {
        _11 test = new _11();
        int[] height = {1,1,2,4,5};
        System.out.println(test.maxArea(height));
    }
}
