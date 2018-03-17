package com.leetcode.myCode;

public class _74 {
    //14ms submission
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = colLength - 1; j >= 0; j--) {
                if (matrix[i][j] == target) return true;
                else if (matrix[i][j] > target) continue;
                else if (matrix[i][j] < target) break;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        _74 test = new _74();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(test.searchMatrix(matrix, 3));
    }
}
