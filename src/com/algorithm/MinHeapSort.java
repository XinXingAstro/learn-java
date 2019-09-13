package com.algorithm;

public class MinHeapSort {
    private int heapsize;
    public void minHeapSort(int[] a) {
        heapsize = a.length - 1;
        buildMinHeap(a);
        while (heapsize >= 1) {
            swap(a, 1, heapsize);
            heapsize--;
            minHeapify(a, 1);
        }
    }
    public void buildMinHeap(int[] a) {
        for (int i = heapsize >> 1; i >= 1; i--) {
            minHeapify(a, i);
        }
    }
    public void minHeapify(int[] a, int i) {
        int l = i << 1;
        int r = l + 1;
        int min = i;
        if (l <= heapsize && a[l] < a[min])
            min = l;
        if (r <= heapsize && a[r] < a[min])
            min = r;
        if (i != min) {
            swap(a, i, min);
            minHeapify(a, min);
        }
    }
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {0,4,5,1,6,2,7,3,8};
        MinHeapSort minHeapSort = new MinHeapSort();
        minHeapSort.minHeapSort(a);
        for (int i : a)
            System.out.print(i + " ");
    }
}
