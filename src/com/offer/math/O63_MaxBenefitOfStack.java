package com.offer.math;

/**
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖股票一次可能获得的最大利润是多少
 * 算法：记录最小值和最大差值
 * 当扫描到数组中第i个数的时候，如果能知道i前面数中的最小值，就可以得到最大差值，逐个扫描数组
 * 中的数，得到所有数的最大差值，就是可能获得的最大利润
 */
public class O63_MaxBenefitOfStack {
    public int MaxDiff(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = nums[0];
        int maxDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            int diff = nums[i] - min;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
    public static void main(String[] args) {
        O63_MaxBenefitOfStack test = new O63_MaxBenefitOfStack();
        int[] nums = {9,11,8,5,7,12,17,14};
        System.out.print(test.MaxDiff(nums));
    }
}
