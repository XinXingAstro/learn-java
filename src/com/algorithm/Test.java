package com.algorithm;

public class Test {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9,2,4,6,10};
        int[] nums2 = {9,8,7,6,5,4,3,2,1};

//        Bubblesort bb = new Bubblesort();
//        long a = System.currentTimeMillis();
//        bb.bubblesort1(nums1);
//        long b = System.currentTimeMillis();
//        long cost = b - a;
//        Selectionsort ss = new Selectionsort();
//        ss.selectionsort(nums2);

//        Insertionsort is = new Insertionsort();
//        is.insertionsort(nums1);
//        Selectionsort ss = new Selectionsort();
//        ss.selectionsort(nums1);
//        Quicksort qs = new Quicksort();
//        qs.quick3Way(nums1, 0, nums2.length-1);
        Mergesort ms = new Mergesort();
        ms.mergesort(nums1, 0, nums1.length-1);
        for (int i : nums1) {
            System.out.print(i);
        }
//        System.out.print("\n" + cost);
    }
}
