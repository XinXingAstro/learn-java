package com.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PinDuoDuo_BearEatSugar {
    static class Bear {
        public int fight;
        public int hungry;
        public int id;

        Bear(int fight, int hungry, int id) {
            this.fight = fight;
            this.hungry = hungry;
            this.id = id;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sugars = new int[m];
        for (int i = 0; i < m; i++) {
            sugars[i] = sc.nextInt();
        }
        Bear[] bears = new Bear[n];
        for (int i = 0; i < n; i++) {
            bears[i] = new Bear(sc.nextInt(), sc.nextInt(), i);
        }
        Arrays.sort(bears, new Comparator<Bear>() {
            @Override
            public int compare(Bear o1, Bear o2) {
                return o2.fight - o1.fight;
            }
        });
        Arrays.sort(sugars);
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = sugars.length - 1; i >= 0; i--) {
                if (sugars[i] != 0 && sugars[i] <= bears[j].hungry) {
                    bears[j].hungry -= sugars[i];
                    sugars[i] = 0;
                }
            }
            ans[bears[j].id] = bears[j].hungry;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}
