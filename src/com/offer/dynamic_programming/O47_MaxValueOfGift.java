package com.offer.dynamic_programming;

/**
 * 在m*n的棋盘上每一格都有一个礼物，每个礼物有一定价值，从棋盘左上角开始，每次向右或向下移动一格
 * 直到到达棋盘的右下角，给定一个棋盘及其上面的礼物，计算最多能拿到多少礼物的价值
 *
 * 算法：动态规划
 * 定义f(i,j)表示到达坐标为(i,j)的格子时能拿到的礼物总和的最大值，根据题目要求我们有两种可能到达(i,j)
 * 通过格子(i-1,j)或者(i,j-1)，所以f(i,j) = max(f(i-1,j),f(i,j-1)) + gift(i,j)，其中gift(i,j)
 * 表示格子(i,j)中礼物的价值
 * 我们只要建立一个二维辅助数组，计算并存储每一个格子里的f(i,j)最后右下角的f(i,j)值就是最后拿到礼物的最大值
 *
 * 优化：没有必要用整个二维数组存储中间结果，计算每一个格子的f(i,j)值时只是需要直到格子左边或者上面的值，
 * 所以只要用一个一维数组存储中间结果就可以
 */
public class O47_MaxValueOfGift {
    public int getMacValueOfGift(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }

        int[] maxValue = new int[nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValue[j];
                }
                if (j > 0) {
                    left = maxValue[j - 1];
                }
                maxValue[j] = Math.max(left, up) + nums[i][j];
            }
        }
        return maxValue[nums[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,10,3,8},{11,2,9,6},{5,8,4,11},{3,7,16,5}};
        O47_MaxValueOfGift test = new O47_MaxValueOfGift();
        System.out.print(test.getMacValueOfGift(nums));
    }
}
