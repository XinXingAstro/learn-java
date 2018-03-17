package com.offer.string_array;

/**
 * 表示数值的字符串
 *
 * 数字字符串模式：A[.[B]][e|EC] || .B[e|EC]
 * A为整数部分，B为小数部分，C为指数部分
 *
 * 1)A不是必须的，如：.123 = 0.123
 * 2)B紧跟着小数点
 * 3)C紧跟着e或者E
 * 4)如果一个数没有整数部分，那么他的小数部分不能为空
 * 5)A和C都是可能以'+'或'-'开头的0～9的数位串，B是不能以'+'或'-'号开头的0～9的数位串
 */
public class O20_NumericString {
    public int index = 0;

    boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }

        boolean numeric = scanInteger(str);

        //如果出现'.'，则后面的数字是小数部分
        if(index < str.length && str[index] == '.') {
            index++;

            //下面代码用||的原因
            //1.小数可以没有整数部分，如.123 = 0.123;
            //2.小数点后面可以没有数字，如233. = 233.0;
            //3.小数点前面和后面可以都有数字，如233.666;
            numeric = scanUnsignedInteger(str) || numeric;
        }

        //如果出现'e'或者'E'，则接下来是数字的指数部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;

            //使用&&的原因：
            //1.当e或E前面没有数字时，整个字符串不能表示数字，如.e1, e1;
            //2.当e或E后面没有整数时，整个字符串不能表示数字，如12e, 12e+5.4;
            numeric = numeric && scanInteger(str);
        }

        return numeric && (index == str.length);
    }

    /**
     * scanInteger扫描可能以'+'或者'-'为起始的0～9的数位，用来匹配A和C
     * @param str
     * @return
     */
    boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    /**
     * scanUnsignedInteger用来扫描字符串中0～9的数位，用来匹配B部分
     * @param str
     * @return
     */
    boolean scanUnsignedInteger(char[] str) {
        int before = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }

        //当str中存在若干0～9的数值时， 返回true；
        return index > before;
    }

    public static void main(String[] args) {
        O20_NumericString test = new O20_NumericString();
        String str = "12e";
        System.out.print(test.isNumeric(str.toCharArray()));
    }
}
