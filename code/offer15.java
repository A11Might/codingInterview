package offer;

/**
 * [15] 二进制中1的个数
 * 
 * 题目：输出给定整数二进制表示中1的个数(其中负数用补码表示)
 * 
 * 思路：1、使用右移操作，从右到左判断每一位上的数是否为1
 *      2、(n - 1) & n操作可以将n的最右边的1变为0
 *         计算可以进行多有次此操作，就有多少个1，如；
 *         (1100 - 1) & 1100 = 1011 & 1100 = 1000
 *          (减1操作将原数字最右边的1变为0，其后为变为1
 *          与原数字&后，即将原数字最右边的1变为零)
 */
public class Solution {
    public int NumberOf11(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }

        return count;
    }

    public int NumberOf12(int n) {
        int count = 0;
        // when n not equal 0, explain n have one 1 at last
        // count plus one
        // then n = (n - 1) & n operation n lost this one 1
        // and continue judge n is equal 0 or not
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }
}
