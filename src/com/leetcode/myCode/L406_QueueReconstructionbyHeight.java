package com.leetcode.myCode;

import java.util.*;

public class L406_QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]);
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] p : people)
            list.add(p[1], p);
        return list.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        L406_QueueReconstructionbyHeight test = new L406_QueueReconstructionbyHeight();
        System.out.println(test.reconstructQueue(people));
    }
}
