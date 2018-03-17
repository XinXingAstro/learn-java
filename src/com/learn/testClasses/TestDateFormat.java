package com.learn.testClasses;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");//DateFormat是一个抽象类，不能new一个DataFormat对象
        //yyyy-mm-dd hh:mm:ss是格式化字符串，SimpleDateFormat类会根据这个字符串对时间进行处理
        Date d = new Date(124214124L);
        String str = df.format(d);
        System.out.println(str);
    }
}
