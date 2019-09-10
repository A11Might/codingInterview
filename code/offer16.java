package offer;

/**
 * [16] 数值的整数次方
 * 
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * 
 * 思路：1、快幂算法， a ^ n = (a ^ (n / 2)) * (a ^ (n / 2)) if n 为偶数
 *                         = (a ^ ((n - 1) / 2)) * (a ^ ((n - 1) / 2)) * a if n 为奇数
 *      2、位运算计算幂，exponent二进制数的每一位上如果值为1，表示该位有值，最后一位对应的值是base
 *                      倒数第二位对应的是base平方，倒数第三位base平方的平方，以此类推，设结果的初
 *                      始值为res = 10， 发现对应位置上的数为1，九江result乘以对应值
 *      
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
        boolean flag = exponent > 0 ? true : false;
        exponent = Math.abs(exponent);
        // imitate quick power calculate
        double res = base;
        while (exponent >= 2) {
            res *= res;
            if ((exponent & 1) == 1) {
                res *= base;
            }
            exponent >>= 1;
        }

        return flag ? res : 1 / res;
    }

    public double Power2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean flag = exponent > 0 ? true : false;
        exponent = Math.abs(exponent);
        // initialize res as 1
        double res = 1;
        while (exponent > 0) {
            // from back to front, judge every position is 1 or 0
            // if it's 1 multiply current base
            if ((exponent & 1) == 1) {
                res *= base;
            }
            // calculate every position's base
            base *= base;
            // move to next position
            exponent >>= 1;
        }

        return flag ? res : 1 / res;
    }
}
