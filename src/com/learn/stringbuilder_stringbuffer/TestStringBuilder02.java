package com.learn.stringbuilder_stringbuffer;

public class TestStringBuilder02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        sb.delete(3, 5); //包头不包尾：包括第3个字符不包括第5个字符
        System.out.println(sb); //abcfghijklmnopqrstuvwxyz

        sb.reverse(); //字符反转
        System.out.println(sb); //zyxwvutsrqponmlkjihgfcba

        StringBuffer sb2 = new StringBuffer();
        //StringBuffer和StringBuilder区别：StringBuffer里的方法前面都有synchronized关键字，
        //有synchronized关键字就是线程安全的，要调用这个方法必须有对象锁
        String sb3 = new String();
    }
}
