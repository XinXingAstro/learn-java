package com.learn.testIO;

import java.io.*;

public class TestPrintStream1 {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("/Users/xinxing/Desktop/log.dat");
            ps = new PrintStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ps != null) {
            System.setOut(ps);
        }
        int In = 0;
        for (char c = 0; c <= 60000; c++) {
            System.out.print(c + " ");
            if (In++ >= 100) {
                System.out.println();
                In = 0;
            }
        }
    }
}
