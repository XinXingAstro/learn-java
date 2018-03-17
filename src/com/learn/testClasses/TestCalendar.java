package com.learn.testClasses;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        c.set(2017, 9, 01);
        System.out.println(c.getTime());

    }
}
