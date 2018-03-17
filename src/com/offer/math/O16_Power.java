package com.offer.math;

import java.util.Stack;

/**
 * 数值的整数次方，考察对base=0，exponent为复数的特殊情况
 * 计算整数次方的时候可以用分治策略，只下而上进行计算，将时间复杂度从O(n)降到O(lgn)
 */
public class O16_Power {
    public boolean invalidInput = false;

    public double power(double base, int exponent) {
        invalidInput = false;

        if (base == 0 && exponent < 0) {
            invalidInput = true;
            return 0.0;
        }

        if (exponent < 0) {
            double result = iterativePowerCore(base, -exponent);
            return 1.0 / result;
        } else {
            return iterativePowerCore(base, exponent);
        }
    }

    public double powerCore(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerCore(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }

    public double iterativePowerCore(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        Stack<Integer> exps = new Stack<Integer>();
        int temp = exponent;
        while(temp > 1) {
            exps.push(temp);
            temp = temp >> 1;
        }

        double result = base;
        while(!exps.empty()) {
            result *= result;
            if ((exps.pop() & 0x1) == 1) {
                result *= base;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        O16_Power test = new O16_Power();
        System.out.println(test.power(2.0, 0));
    }
}
