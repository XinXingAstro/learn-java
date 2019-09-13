package com.offer.string_array;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 在输入数组中找出最小的K个数
 * 算法1：
 * 快排的partition的原理是每次确定一个元素在数组中的最终位置，他左边的数都比他小
 * 右边的数都比他大，所以我们只要用partition函数找到位于k-1位置的数，就可以确定数组中最小
 * 的k个数。时O(n) 空O(1)
 * 缺点：必须要修改输入数组，不能处理大数据量
 *
 * 算法2：（适合处理大数据，不用修改数组）
 * 从输入数据一个一个的读取数据，使用一个容器记录最小的K个数，为了保证效率，这个容器应该使用两种
 * 数据结构实现：最大堆、红黑树
 * 最大堆：读最大元素O(1)，插入元素O(logk)，删除元素O(logk)
 * 红黑树：读最大元素，插入元素，删除元素的效率都是O(logk)
 */
public class O40_FindLeastKNumbers {
    /**
     * 算法1：用快排的partition函数实现
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_1(int[] input, int k) {
        if (input == null || input.length < k || k <= 0) {
            return new ArrayList<Integer>();
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != (k - 1)) {
            if (index < (k - 1)) {
                start = index + 1;
                index = partition(input, start, end);
            } else {
                end = index - 1;
                index = partition(input, start, end);
            }
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            output.add(input[i]);
        }
        return output;
    }

    public int partition(int[] array, int start, int end) {
        int index = start + (int)(Math.random() * (end - start + 1));
        swap(array, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (array[i] < array[end]) {
                small++;
                swap(array, small, i);
            }
        }
        small++;
        swap(array, small, end);
        return small;
    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * 算法2
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_2(int[] input, int k) {
        if (input == null || input.length < k || k <= 0) {
            return new ArrayList<Integer>();
        }
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (ts.size() < k) {
                ts.add(input[i]);
            } else {
                if (ts.last() > input[i]) {
                    ts.pollLast();
                    ts.add(input[i]);
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        output.addAll(ts);
        return output;
    }

    /**
     * 算法3：用最小堆实现
     * @param args
     */
    private int heapsize;
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (input == null || input.length < k)
            return ans;
        heapsize = input.length;
        buildHeap(input);
        while (heapsize >= 1) {
            swap1(input, 1, heapsize);
            heapsize--;
            maxHeapify(input, 1);
        }
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
            System.out.println(input[i]);
        }
        return ans;
    }
    public void buildHeap(int[] a) {
        for (int i = heapsize>>1; i >= 1; i--) {
            maxHeapify(a, i);
        }
    }
    public void maxHeapify(int[] a, int i) {
        int l = i << 1;
        int r = l + 1;
        int largest = i;
        if (l <= heapsize && a[l-1] > a[largest-1])
            largest = l;
        if (r <= heapsize && a[r-1] > a[largest-1])
            largest = r;
        if (i != largest) {
            swap1(a, i, largest);
            maxHeapify(a, largest);
        }
    }
    public void swap1(int[] a, int i, int j) {
        int temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }

    public static void main(String[] args) {
        O40_FindLeastKNumbers test = new O40_FindLeastKNumbers();
        int[] input = {4,5,1,6,2,7,3,8};
        System.out.println(test.GetLeastNumbers_Solution_2(input, 4));
    }
}
