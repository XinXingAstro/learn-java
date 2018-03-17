package com.learn.testClasses;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File f1 = new File("/Users/xinxing/Desktop/A.txt");
        File f2 = new File("/Users/xinxing/Desktop/");
        File f3 = new File(f2, "B.txt");

        System.out.println(f1.isFile());//true
        System.out.println(f2.isFile());//false

        System.out.println(f1.isDirectory());//false
        System.out.println(f2.isDirectory());//true

        System.out.println(f1.compareTo(f3));//-1
    }
}
