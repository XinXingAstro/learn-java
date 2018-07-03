package com.leetcode.myCode;

public class L695_MaxAreaofIsland {
    private int res, island;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    island = 0;
                    DFS(grid, i, j);
                }
            }
        }
        return res;
    }
    public void DFS(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1;
        island++;
        if (res < island) res = island;
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
        DFS(grid, i - 1, j);
        DFS(grid, i + 1, j);
    }
    public static void main(String[] args) {
        int[][] a = {{1,1},{1,0}};
        System.out.println(new L695_MaxAreaofIsland().maxAreaOfIsland(a));
    }
}
