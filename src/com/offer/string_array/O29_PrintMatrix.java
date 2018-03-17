package com.offer.string_array;

import java.util.ArrayList;

/**
 * 顺时针从外向里打印矩阵
 * 难点：边界控制
 */
public class O29_PrintMatrix {

    ArrayList<Integer> printBuffer = new ArrayList<Integer>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int start = 0;
        while (start*2 < matrix.length && start*2 < matrix[0].length) {
            printOneCircle(matrix, start);
            start++;
        }

        return printBuffer;
    }

    public void printOneCircle(int[][] matrix, int start) {
        int endX = matrix[0].length - 1 - start;//定义终止列号
        int endY = matrix.length - 1 - start;   //定义终止行号

        // I.从左到右打印第一行，第一步总是需要的
        for (int i = start; i <= endX; i++) {
            printBuffer.add(matrix[start][i]);
        }

        // II.如果终止行号大于start行号，则从上到下打印一列
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                printBuffer.add(matrix[i][endX]);
            }
        }

        // III.如果start列号小于终止列号，并且至少右两行，则从右向左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                printBuffer.add(matrix[endY][i]);
            }
        }

        // IV.如果start小于终止行号-1， 并且至少右两列，则从下到上打印一列
        if (start < endY - 1 && start < endX) {
            for (int i = endY - 1; i >= start + 1; i--) {
                printBuffer.add(matrix[i][start]);
            }
        }
    }
}
