package com.leetcode.bestCode;

public class _74 {
    //0ms submission
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }

        int startrow = 0;
        int endrow = matrix.length - 1;
        int row = -1;
        int col = matrix[0].length - 1;

        while (startrow + 1 < endrow) {
            int mid = startrow + (endrow - startrow) / 2;
            if (matrix[mid][col] < target) {
                startrow = mid;
            } else {
                endrow = mid;
            }
        }

        if (matrix[startrow][col] >= target) {
            row = startrow;
        } else if (matrix[endrow][col] >= target) {
            row = endrow;
        } else
            return false;

        int i = 0;
        while (i + 1 < col) {
            int mid = i + (col - i) / 2;
            if (matrix[row][mid] < target) {
                i = mid;
            } else {
                col = mid;
            }
        }

        if (matrix[row][i] == target) {
            return true;
        }
        if (matrix[row][col] == target) {
            return true;
        }
        return false;
    }
}