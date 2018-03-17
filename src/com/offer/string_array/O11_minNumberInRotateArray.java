package com.offer.string_array;

public class O11_minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception();
        }

        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }

            mid = (end + start) / 2;
            if (array[start] == array[mid] && array[mid] == array[end]) {
                return findMin(array);
            }
            if (array[mid] >= array[start]) {
                start = mid;
            }
            if (array[mid] <= array[end]) {
                end = mid;
            }
        }
        return array[mid];
    }

    public int findMin(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        O11_minNumberInRotateArray test = new O11_minNumberInRotateArray();
        int[] a1 = {1,0,1,1,1};
        int[] a2 = {3,4,5,1,2};
        int[] a3 = {1,2,3,4,5,6,7};
        try {
            System.out.println(test.minNumberInRotateArray(a1));
            System.out.println(test.minNumberInRotateArray(a2));
            System.out.println(test.minNumberInRotateArray(a3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
