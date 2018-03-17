package com.offer.string_array;

/**
 * 输入字符串，将字符串转换成整数
 * 算法：
 * 注意异常情况的处理：
 * 1）输入字符串为null
 * 2）输入字符串为""
 * 3）输入字符串为"+"或"-"
 * 4）输入字符串包含处数字和加减号以外的字符
 * 5）输入字符串的数字大于最大正数，或者小于最小负数
 */
public class O67_StringToInt {
    public int StrToInt(String str) {
        //捕获1 2号异常
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                return str.charAt(0) - '0';
            } else {
                return 0;
            }
        } else {
            int minus = 0;
            int i = 0;
            int num = 0;
            //捕获3号异常
            if (str.charAt(0) == '-') {
                minus = 1;
                i++;
            }
            if (str.charAt(0) == '+') {
                i++;
            }
            while (i < str.length()) {
                //捕获4号异常
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return 0;
                }
                num = (str.charAt(i) - '0') + num * 10;
                i++;
            }
            return minus == 0 ? num : -num;
        }
    }
}
