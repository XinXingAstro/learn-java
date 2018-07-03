package com.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TX_GameId {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ids = br.readLine().trim().split(" ");
        int id1 = Integer.parseInt(ids[0]);
        int id2 = Integer.parseInt(ids[1]);
        if (id1 < 1 || id1 > 1024 || id2 < 1 || id2 > 1024)
            System.out.println(-1);
        else if (id1 == id2)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
