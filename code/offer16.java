package offer;

/**
 * [16] 数值的整数次方
 * 
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * 
 * 思路：快幂算法， a ^ n = (a ^ (n / 2)) * (a ^ (n / 2)) if n 为偶数
 *                       = (a ^ ((n - 1) / 2)) * (a ^ ((n - 1) / 2)) * a if n 为奇数
 */     
public class Solution {
    // recursion
    public double Power1(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // judge exponent is positive or nagetive
        // to decide return res or 1 / res
        boolean flag = exponent > 0 ? true : false;
        exponent = Math.abs(exponent);
        // a ^ n = (a ^ (n / 2)) * (a ^ (n / 2))
        double res = Power1(base, exponent >> 1);
        res *= res;
        // a ^ n = (a ^ ((n - 1) / 2)) * (a ^ ((n - 1) / 2)) * a
        // if exponent is uneven number
        // should multiply base one more time
        if ((exponent & 1) == 1) {
            res *= base;
        }

        return flag ? res : 1 / res;
    }

    // iteration
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // judge exponent is positive or nagetive
        // to decide return res or 1 / res
        boolean flag = exponent > 0 ? true : false;
        exponent = Math.abs(exponent);
        double res = base;
        // a ^ n = (a ^ (n / 2)) * (a ^ (n / 2))
        while (exponent > 1) {
            res *= res;
            exponent >>= 1;
        }
        // a ^ n = (a ^ ((n - 1) / 2)) * (a ^ ((n - 1) / 2)) * a
        // if exponent is uneven number
        // should multiply base one more time
        if (exponent == 1) {
            res *= base;
        }

        return flag ? res : 1 / res;
    }
}
