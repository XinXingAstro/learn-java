package com.learn.testClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历
 */
public class VisualCalendar {
    public static void main(String[] args) {
        System.out.println("请输入日期，例如：2000-01-01");
        Scanner s = new Scanner(System.in);
        String tempDate = s.nextLine();
//        String tempDate = "2030-02-05";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int n = 0;
        int m = 0;
        int day =0;
        try {
            Date d = df.parse(tempDate);
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            day = c.get(Calendar.DATE);
            c.set(Calendar.DATE, 1);//将日期设置为1
            n = c.get(Calendar.DAY_OF_WEEK)-1;//得到1好对应的星期数 -1得到打印时1号前面空几格
//            System.out.println(c.get(Calendar.DAY_OF_WEEK));
            m = c.getActualMaximum(Calendar.DATE);//得到该月对应的最大天数
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int j = 0;
        for(int i=0; i < n; i++) {
            System.out.print("\t");
            j++;
        }
        for(int i = 1; i <= m; i++) {
            if(i == day) System.out.print("*");
            System.out.print(i + "\t");
            j++;
            if(j%7 == 0) {
                System.out.print("\n");
            }
        }
    }
}
