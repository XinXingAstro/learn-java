package com.concurrent;

public class ThreadExample01 {
    static class myThread extends Thread {
        @Override
        public void run() {
            System.out.println("myThread running");
        }
    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new myThread().start();
    }
}
