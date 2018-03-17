package com.offer.string_array;

/**
 * 从矩阵的对角线顶点开始搜索
 * 每次删除一行或一列
 * 和Leetcode 240题一样
 */
public class O4_Search2DMatrix {
    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = (array[0].length - 1);
        while (row < array.length && col >= 0) {
            if (array[row][col] == target) {
                return true;
            }
            else if (array[row][col] > target) {
                col--;
            }
            else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array1 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] array2 = {{0,1}};
        System.out.println(Find(1, array2));
    }
}
