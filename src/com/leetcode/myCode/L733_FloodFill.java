package com.leetcode.myCode;

public class L733_FloodFill {
    private int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc];
        if (oldColor != newColor)
            DFS(image, sr, sc, newColor);
        return image;
    }
    public void DFS(int[][] image, int i, int j, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor)
            return;
        image[i][j] = newColor;
        DFS(image, i + 1, j, newColor);
        DFS(image, i - 1, j, newColor);
        DFS(image, i, j + 1, newColor);
        DFS(image, i, j - 1, newColor);
    }
}
