package com.leetcode.myCode;

public class L85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        int[] h = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') h[j] += 1;
                else h[j] = 0;
            }
            maxArea = Math.max(maxArea, getMax(h, 0, n-1));
        }
        return maxArea;
    }
    private int getMax(int[] h, int left, int right) {
        if (left > right) return 0;
        if (left == right) return h[left];
        int minIndex = left;
        boolean sorted = true;
        for (int i = left+1; i <= right; i++) {
            if (h[i] < h[i-1]) sorted = false;
            if (h[i] < h[minIndex]) minIndex = i;
        }
        if (sorted) {
            int max = 0;
            for (int i = left; i <= right; i++) {
                int area = h[i] * (right - i + 1);
                if (area > max) max = area;
            }
            return max;
        } else {
            int maxLeft = getMax(h, left, minIndex-1);
            int maxRight = getMax(h, minIndex+1, right);
            int crossMax = h[minIndex] * (right - left + 1);
            return Math.max(Math.max(maxLeft, maxRight), crossMax);
        }
    }

    public static void main(String[] args) {
        L85_MaximalRectangle test = new L85_MaximalRectangle();
        char[][] matirx = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.print(test.maximalRectangle(matirx));
    }
}
