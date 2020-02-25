/**
 * [15] 二进制中 1 的个数
 *
 * 题目: 输入一个整数, 输出该数二进制表示中 1 的个数.
 *
 * 思路: 1. 使用无符号右移操作, 从右到左判断二进制表示的每一位上的数是否为 1.
 *      2. (n - 1) & n操作可以将 n 的最右边的 1 变为 0, 所以计算可以进行多少次此操作, 就有多少个1.
 *         如: (1100 - 1) & 1100 = 1011 & 1100 = 1000.
 *         (减 1 操作将原数字最右边的 1 变为 0, 其后所有位变为 1 与原数字 & 后, 即将原数字最右边的 1 变为 0)
 */
public class Solution {
    /**
     * 时间复杂度: O(m) (m 表示 n 的二进制位数)
     * 空间复杂度: O(1)
     */
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int cnt = 0;
        while (n != 0) {
            // judge every position of n's binary number is 1 or not,
            // and count 1's appeared times.
            cnt += n & 1;
            n >>>= 1;
        }

        return cnt;
    }

    /**
     * 时间复杂度: O(m) (m 表示 n 的二进制中 1 的个数)
     * 空间复杂度: O(1)
     */
    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int cnt = 0;
        // when n not equal 0, explain n have one 1 at last, cnt plus one.
        // then n = (n - 1) & n operation let n lost this one 1 which Just accumulated,
        // and continue judge n is equal 0 or not.
        while (n != 0) {
            cnt++;
            n = (n - 1) & n;
        }

        return cnt;
    }
}