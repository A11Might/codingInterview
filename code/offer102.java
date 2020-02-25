/**
 * [10-II] 青蛙跳台阶问题
 *
 * 题目: 一只青蛙一次可以跳上 1 级台阶, 也可以跳上 2 级台阶. 求该青蛙跳上一个 n 级的台阶总共有多少种跳法.
 *      (答案需要取模 1e9 + 7 (1000000007))
 *
 * 思路: 动态规划, f(i) 表示 i 个台阶一共有多少种跳法;
 *               状态转移方程: f(i) = f(i - 1) + f(i - 2).
 *       与 [10-I] 斐波那切数列的不同在于, 此题的 f(0) = 1, f(1) = 1(斐波那切数列的 f(0) = 0, f(1) = 1).
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int pre = 1, succ = 1;
        for (int i = 2; i <= n; i++) {
            // state transition equation: f(i) = f(i - 1) + f(i - 2).
            int fib = (pre + succ) % (int) (1e9 + 7);
            pre = succ;
            succ = fib;
        }

        return succ;
    }
}