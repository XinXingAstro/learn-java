package com.leetcode.myCode;

import java.util.ArrayList;

public class L807_MaxIncreasetoKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;
        int[] rowMax = findRowMax(grid);
        int[] colMax = findColMax(grid);
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < rowMax[i] && grid[i][j] < colMax[j]) {
                    sum += Math.min(rowMax[i], colMax[j]) - grid[i][j];
                }
            }
        }
        return sum;
    }
    public int[] findRowMax(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (max < grid[i][j])
                    max = grid[i][j];
            }
            rowMax[i] = max;
            max = Integer.MIN_VALUE;
        }
        return rowMax;
    }
    public int[] findColMax(int[][] grid) {
        int[] colMax = new int[grid[0].length];
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (max < grid[i][j])
                    max = grid[i][j];
            }
            colMax[j] = max;
            max = Integer.MIN_VALUE;
        }
        return colMax;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(new L807_MaxIncreasetoKeepCitySkyline().maxIncreaseKeepingSkyline(grid));
    }
}
