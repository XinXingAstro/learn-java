package com.algorithm;

public class Heapsort {
    private int heapSize;
    public void heapSort(int[] a) {
        heapSize = a.length - 1;
        buildMaxHeap(a);
        for (int i = heapSize; i >= 2; i--) {
            swap(a, 1, i);
            heapSize--;
            maxHeapify(a, 1);
        }
    }
    public void buildMaxHeap(int[] a) {
        for (int i = (heapSize>>1); i >= 1; i--)
            maxHeapify(a, i);
    }
    public void maxHeapify(int[] a, int i) {
        int l = 2 * i;
        int r = 2 * i + 1;
        int largest = i;
        if (l <= heapSize && a[l] > a[i])
            largest = l;
        if (r <= heapSize && a[r] > a[largest])
            largest = r;
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest);
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Heapsort heapsort = new Heapsort();
        int[] a = {0,16,4,12,12,14,7,9,3,2,8,1};
//        heapsort.maxHeapify(a, 2);
//        heapsort.buildMaxHeap(a);
        heapsort.heapSort(a);
        for (int i : a)
            System.out.print(i + " ");
    }
}
