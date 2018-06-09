package com.leetcode.myCode;

public class L48_RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix.length;
        for (int i = 0; i <= (n-2); i++) {
            for (int j = (i+1); j <= (n-1); j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i <= (n-1); i++) {
            for (int j = 0; j < (n >> 1); j++) {
                // swap(matrix[i][j], matrix[i][n-1-j]);
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}
