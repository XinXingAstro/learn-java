package com.offer.string_array;

/**
 * 用回溯算法在矩阵中查找路径
 */
public class O12_MatrixPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;

        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {

        if (str.length == pathLength) {
            return true;
        }


        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            ++pathLength;
            visited[row * cols + col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);

            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        int rows = 3;
        int cols = 4;
        char[] str = {'A','B','C','C','E','D'};
        O12_MatrixPath test = new O12_MatrixPath();
        System.out.println(test.hasPath(matrix, rows, cols, str));
    }
}
