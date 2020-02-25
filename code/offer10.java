/**
 * [10-I] 斐波那切数列
 *
 * 题目: 返回斐波那契数列的第 n 项(斐波那契数列由 0 和 1 开始).
 *      (答案需要取模 1e9 + 7 (1000000007))
 *
 * 思路: 动态规划, f(i) 表示第 i 项斐波那契数列;
 *               状态转移方程: f(i) = f(i - 1) + f(i - 2).
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int pre = 0, succ = 1;
        for (int i = 2; i <= n; i++) {
            // state transition equation: f(i) = f(i - 1) + f(i - 2).
            int fib = (pre + succ) % (int) (1e9 + 7);
            pre = succ;
            succ = fib;
        }

        return succ;
    }
}