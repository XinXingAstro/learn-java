package com.leetcode.myCode;

public class L463_IslandPerimeter {
    private int res;
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    DFS(grid, i, j);
                    return res;
                }
            }
        }
        return res;
    }
    public void DFS(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return;
        grid[i][j] = -1;
        if (i - 1 < 0 || grid[i - 1][j] == 0 ) // up
            res++;
        if (i + 1 >= grid.length || grid[i + 1][j] == 0) // down
            res++;
        if (j - 1 < 0 || grid[i][j - 1] == 0) // left
            res++;
        if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) // right
            res++;
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }

    public int islandPerimeter1(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) res -= 2;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) res -= 2;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{1}};
        System.out.println(new L463_IslandPerimeter().islandPerimeter(a));
    }
}
