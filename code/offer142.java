/**
 * [14-II] 剪绳子
 *
 * 题目: 给你一个长度为 n 的绳子, 请将绳子剪成整数长度的 m 段(m, n都是整数, n > 1 且 m > 1即至少剪一刀), 返回每段绳子长度的最大乘积.
 *      (答案需要取模 1e9 + 7 (1000000007))
 *      (与[面试题14-I] 剪绳子不同的是: 2 <= n <= 1000)
 *
 * 思路: 贪心策略, 当 n >= 5 时, 尽可能地多剪长度为 3 的绳子;
 *               当剩下的绳子长度为 4 时, 把绳子剪成两段长度为 2 的绳子.
 *      证明: 当 n >= 5 时, 3(n - 3) - n = 2n - 9 > 0, 且 2(n - 2) - n = n - 4 > 0. 因此在 n >= 5 的情况下, 将绳子剪成一段
 *      为 2 或者 3, 得到的乘积会更大. 又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，所以剪成一段长度为 3 比长度为 2 得到的乘积更大.
 */
class Solution {
    /**
     * 时间复杂度: O(logn)
     * 空间复杂度: O(1)
     */
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int mod = (int) (1e9 + 7);
        long ret = 1;
        // when current n's value is bigger or equal with 5, cut a length 3 part.
        while (n >= 5) {
            ret *= 3;
            ret %= mod;
            n -= 3;
        }

        // rest length is 4, its should be divide to 2 and 2.
        // means when n == 4, max product == 2 * 2 == 4.
        return (int) (ret * n % mod);
    }
}
