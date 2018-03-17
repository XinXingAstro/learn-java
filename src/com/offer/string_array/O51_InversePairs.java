package com.offer.string_array;

/**
 * 数组中的逆序数
 * 输入一个数组，求出这个数组中的逆序对的总数
 * 算法：在归并排序的基础上进行排序
 * 将数组分为两部分，分别统计各部分内部的逆序对数，并将各部分排序，将两部分合并，在合并的过程中统计逆序对
 */
public class O51_InversePairs {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        int count = inversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }
    public int inversePairsCore(int[] array, int[] copy, int start, int end) {
        //递归出口
        if (start == end) {
            //copy[start] = array[start];
            return 0; //对于单个元素逆序数是0，所以返回0
        }

        int length = (end - start) >> 1;//定义对半划分子数组长度

        //递归调用
        int left = inversePairsCore(copy, array, start, start + length); //递归求出左边数组逆序对数
        int right = inversePairsCore(copy, array, start + length + 1, end); //递归求出右边数组逆序对数

        //计算逆序对实体程序
        int i = start + length; //i指向左边子数组最后一个元素
        int j = end; //j指向右边子数组最后一个元素
        int indexCopy = end; //指向归并辅助数组最后一个位置
        int count = 0; //统计归并过程中的逆序对数
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        //如果左边子树组中还有数据，则全部复制到copy中
        while (i >= start) {
            copy[indexCopy--] = array[i--];
        }

        //如果右边子数组还有数据，则全部复制到copy中
        while (j >= start + length + 1) {
            copy[indexCopy--] = array[j--];
        }

        return left + right + count;
    }

    public static void main(String[] args) {
        O51_InversePairs test = new O51_InversePairs();
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.print(test.InversePairs(array));
    }
}
