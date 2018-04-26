package com.leetcode.myCode;

public class L62_63_UniquePaths {
    //62
    int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n, m);
        int[] cur = new int[m];
        for (int i = 0; i < m; i++) cur[i] = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                cur[i] += cur[i - 1];
            }
        }
        return cur[m - 1];
    }

    // 63
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] cur = new int[m];
        for (int i = 0; i < m; i++) cur[i] = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][j] == 1) cur[i] = 0;
                else cur[i] += cur[i - 1];
            }
        }
        return cur[m - 1];
    }
}
