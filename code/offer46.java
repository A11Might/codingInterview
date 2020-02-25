/**
 * [46] 把数字翻译成字符串
 *
 * 题目: 将给定数字按照如下规则把它翻译为字符串: 0 翻译成 “a”, 1 翻译成 “b”, ... , 25 翻译成 “z”. 返回有多少种不同的翻译方法.
 *
 * 思路: 动态规划: f(i) 表示 i 位置到数字结尾的数字有多少种翻译方法.
 *               状态转移方程: f(i) = f(i - 1) + f(i - 2).
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        int[] dp = new int[len + 1];
        // dynamic programing's base case.
        dp[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            // state transfer equation: f(i) = f(i - 1) + f(i - 2).
            dp[i] = dp[i + 1];
            // if current number start with '0',
            // it can't take two place in the front to translate to string.
            if (str.charAt(i) != '0') {
                // if current number take two place is bigger than 25,
                // it also can't translate to string.
                if (i + 2 <= len && Integer.valueOf(str.substring(i, i + 2)) <= 25) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}