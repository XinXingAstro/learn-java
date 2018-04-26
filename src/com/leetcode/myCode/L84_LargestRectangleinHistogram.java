package com.leetcode.myCode;

import java.util.Stack;

public class L84_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        int maxArea = 0;
        int h, w, height;
        for (int i = 0; i <= length; i++) {
            if (i == length) height = 0;
            else height = heights[i];
            if (stack.isEmpty() || height > heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height < heights[stack.peek()]) {
                    h = heights[stack.pop()];
                    //这里要计算矩形宽度,如果此时栈为空，则说明栈顶矩形条前面没有比该矩形条低的矩形条，
                    //所以左边界就是0，矩形宽度就是i，如果栈中还有元素，则该元素右边就是矩形的左边界，
                    //所以矩形宽度就是 i-(stack.peek() + 1)
                    w = stack.isEmpty() ? i : i - (stack.peek() + 1);
                    maxArea = Math.max(maxArea, h*w);
                }
                stack.push(i);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea02(int[] heights) {
        return getMax(heights, 0, heights.length-1);
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
}
