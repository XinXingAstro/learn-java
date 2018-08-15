package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    static class Bear {
        int id;
        String name;
        Bear(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public void testArrayList() {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        System.out.println(nums);
        for (int i = 0; i < 5; i++) {
            if (nums.get(i) == 1 || nums.get(i) == 2) {
                nums.remove(i--);

            }
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
        /*Bear[] bears = new Bear[10];
        for (int i = 0; i < 10; i++) {
            bears[i] = new Bear(i+1, "xx"+i);
        }
        Bear targetBear = new Bear(12, "XX");
        int res = Arrays.binarySearch(bears, targetBear, new Comparator<Bear>() {
            @Override
            public int compare(Bear o1, Bear o2) {
                return o1.id - o2.id;
            }
        });
        System.out.println(res);*/
        Test test = new Test();
        test.testArrayList();
    }
}
