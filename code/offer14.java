/**
 * [14-I] 剪绳子
 *
 * 题目: 给你一个长度为 n 的绳子, 请将绳子剪成整数长度的 m 段(m, n都是整数, n > 1 且 m > 1即至少剪一刀), 返回每段绳子长度的最大乘积.
 *      (与[面试题14-II] 剪绳子不同的是: 2 <= n <= 58)
 *
 * 思路: 动态规划, f(i)表示将长度 i 的绳子剪成若干段后各段乘积的最大值;
 *              在剪第一刀的时候有 i - 1 种可能的选择, 即剪出的第一段为 1, 2, ..., i - 1,
 *              所以状态转移方程: f(i) = max(f(j) + f(i - j)) j ∈ [1, i).
 */
class Solution {
    /**
     * 时间复杂度: O(n ^ 2)
     * 空间复杂度: O(n)
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 0;
        // from down to up.
        for (int i = 2; i <= n; i++) {
            // just need loop to i / 2.
            int mid = i >> 1;
            // state transition equation is f(i) = max(f(j) + f(i - j)).
            for (int j = 1; j <= mid; j++) {
                // divide current string to two parts,
                // and calculate product what current can be get most.
                // Math.max(dp[j], j) is mean cut current length j string or don't.
                int product = Math.max(dp[j], j) * Math.max(dp[i - j], i - j);
                dp[i] = Math.max(dp[i], product);
            }
        }

        return dp[n];
    }
}
