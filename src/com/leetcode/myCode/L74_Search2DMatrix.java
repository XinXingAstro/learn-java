package com.leetcode.myCode;


public class L74_Search2DMatrix {
    /**
     * Leecode 74题
     * 该题和O4（Leecode第240）题的区别是：
     * 该题多了一个条件：矩阵中上一行最后一个元素的值要大于下一行第一个元素的值
     * 算法1：利用这个条件可以把整个矩阵转行为一个排好序的数组，利用2分直接在数组中查找元素
     * n * m matrix => array: matrix[x][y] => a[x * m + y]
     * array => n * m matrix: a[x] =>matrix[x / m][x % m]
     *
     * 对该方法的优化：I.用二分查找确定数据所在的行. II.用二分查找在该行中查找数据
     * 见算法2，算法3
     *
     * ！该算法不适用于O4，矩阵必须满足上述条件
     */
    public static boolean searchMatrix_1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = (row * col - 1);

        while (start <= end) {
            int m = (start + end) / 2;
            int value = matrix[m/col][m%col];
            if (value == target) return true;
            else if (value < target) start = (m + 1);
            else end = (m - 1);
        }

        return false;
    }

    /**
     * ！该算法不适用于O4，矩阵必须满足上述条件
     *
     * 算法2：用一次遍历搜索，一次二分搜索
     * I.在矩阵最后一列中用遍历搜索找到第一个大于target的数，这个数所在的行有可能包含target
     * II.在该行中用二分搜索查找该数。
     *
     */
    public static boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int targetRow = -1;

        if (target < matrix[0][0] || target > matrix[row][col]) {
            return false;
        }

        for (int i = 0; i <= row; i++) {
            if (matrix[i][col] >= target) {
                targetRow = i;
                break;
            }
        }

        //在target所在的行中用二分搜索查找
        int start = 0;
        int end = col;
        while (start <= end) {
            int mid = (start + end) / 2;
            int value = matrix[targetRow][mid];
            if (value == target) {
                return true;
            } else if (value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    /**
     * ！该算法不适用于O4，矩阵必须满足上述条件
     *
     * 算法3：对算法2的优化用: 两次二分查找
     * I.在矩阵最后一列用二分搜索查找第一个大于target的数，得到target可能在的行
     * II.在该行中用二分搜索查找target
     *
     */
    public static boolean searchMatrix_3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        //在最后一列中，用二分查找搜索第一个大于target的数
        int start = 0;
        int end = matrix.length - 1;
        int col = matrix[0].length - 1;
        int targetRow = -1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int value = matrix[mid][col];
            if (value == target) {
                return true;
            } else if (value > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        //最后一列中，第一个大于等于target的数所在的行有可能包含target
        if (matrix[start][col] >= target) {
            targetRow = start;
        } else if (matrix[end][col] >= target) {
            targetRow = end;
        } else {
            return false;
        }

        //在target所在的行中用二分搜索查找
        start = 0;
        end = col;
        while (start <= end) {
            int mid = (start + end) / 2;
            int value = matrix[targetRow][mid];
            if (value == target) {
                return true;
            } else if (value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
//        System.out.println(L74_Search2DMatrix.searchMatrix_1(matrix, 0));
//        System.out.println(L74_Search2DMatrix.searchMatrix_3(matrix, 60));
        System.out.println(L74_Search2DMatrix.searchMatrix_2(matrix, 50));
    }
}
