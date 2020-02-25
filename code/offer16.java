/**
 * [16] 数值的整数次方
 * 
 * 题目: 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent. 求 base 的 exponent 次方.
 * 
 * 思路: 1. 快幂算法: a ^ n = (a ^ (n / 2)) * (a ^ (n / 2)) if n 为偶数;
 *                        = (a ^ ((n - 1) / 2)) * (a ^ ((n - 1) / 2)) * a if n 为奇数.
 *      2. 位运算计算幂: 二进制表示 exponent ,若当前位置上的值为1, 表示当前位置有值.
 *                     二进制的最后一位对应的值是 base; 倒数第二位对应的是 base平方; 倒数第三位 base 平方的平方, 以此类推.
 *                     设结果的初始值为 res = 1, 发现对应位置上的数为 1, 就将 res 乘以对应的值.
 *      
 */
class Solution {
    /**
     * 时间复杂度: O(logn)
     * 空间复杂度: O(logn)
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        // calculate a ^ (n / 2)) * (a ^ (n / 2).
        double half = myPow1(x, n / 2);
        // if n is odd number n / 2 will rest 1 or -1,
        // then calculate the rest part a ^ (n % 2)).
        double mod = myPow1(x, n % 2);
        return half * half * mod;
    }

    /**
     * 时间复杂度: O(m) (m 为 n 的二进制位数)
     * 空间复杂度: O(1)
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        boolean flag = n > 0 ? true : false;
        // if x is negative number.
        // first calculate the value when it is positive,
        // then just return 1 divide this value.
        n = Math.abs(n);
        // initialize res as 1.
        double ret = 1;
        while (n != 0) {
            // from back to front, judge every position is 1 or 0.
            // if it's 1, ret multiply current x.
            if ((n & 1) == 1) {
                ret *= x;
            }
            // calculate next position's x.
            x *= x;
            // move to next position.
            n >>>= 1;
        }

        // set return value according to flag.
        return flag ? ret : 1 / ret;
    }
}