package com.offer.string_array;

/**
 * 调整数组元素顺序使奇数位于偶数前
 * 考察代码扩展性，要给出一种模式，改变判断函数，解决一系列问题
 */
public class O21_ReOrderArray {
    //不能保证奇数偶数之间相对位置不变
    public void reOrderArray_1(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int begin = 0;
        int end = array.length - 1;

        while(begin < end) {
            while(begin < end && !isEven(array, begin)) {
                begin++;
            }

            while(begin < end && isEven(array, end)) {
                end--;
            }

            if (begin < end) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
    }

    public boolean isEven(int[] array, int index) {
        return ((array[index] & 0x1) == 0);
    }

    /**
     * 保持数组中奇数偶数相对位置不变
     *
     * 算法：冒泡排序的变形，将偶数往后冒 时:O(n^2) 空:O(1)
     *
     * 若想优化时间复杂度，则需要使用额外内存空间，存储数组中所有偶数，
     * 然后将奇数移到数组前面，再将偶数复制到数组后面 时:O(n) 空:O(n)
     *
     * @param array
     */
    public void reOrderArray_2(int[] array){
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = (array.length - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (isEven(array, j - 1) && !isEven(array, j)) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        O21_ReOrderArray test = new O21_ReOrderArray();
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        test.reOrderArray_2(array);
        for(int i : array) {
            System.out.print(i + " ");
        }
    }
}
