package com.learn.stringbuilder_stringbuffer;

/**
 * 不可变字符序列：String
 * 可变字符序列：
 * StringBuilder(线程不安全，效率高）一般用他
 * StringBuffer(线程安全，效率低）
 *
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();  //字符数组长度初始为16
        StringBuilder sb1 = new StringBuilder(32);  //字符数组长度初始为32
        StringBuilder sb2 = new StringBuilder("abcd");  //字符数组长度为32
        sb2.append("123");
        sb2.append(true).append(321).append("..."); //append()通过return this;实现方法链
        System.out.println(sb2); //abcd123true

        StringBuilder sb3 = new StringBuilder("a");
        for(int i = 0; i < 100; i++) {
            sb3.append(i);
        }
        System.out.println(sb3);


    }
}
