/**
 * [19] 正则表达式匹配
 * 
 * 题目: 实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式. 在本题中, 匹配是指字符串的所有字符匹配整个模式.
 *      (模式中的字符 '.' 表示任意一个字符, 而 '*' 表示它前面的字符可以出现任意次(包含 0 次))
 * 
 * 思路: 1. 回溯所有情况.
 *      2. 动态规划, dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配.
 *         https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
 */
class Solution {
    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    public boolean isMatch1(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatchCore(s, 0, p, 0);
    }

    private boolean isMatchCore(String s, int indexOfS, String p, int indexOfP) {
        if (indexOfS == s.length() && indexOfP == p.length()) {
            return true;
        }
        if (indexOfS != s.length() && indexOfP == p.length()) {
            return false;
        }
        // can't estimate match condition:
        // third case, str is end but pattern maybe remain char* could be delete, continue judge.(very important)
        // fourth case, str isn't end and pattern isn't end, continue judge.

        // if next char is '*'.
        if (indexOfP + 1 < p.length() && p.charAt(indexOfP + 1) == '*') {
            if (indexOfS != s.length()
                    // if current str's char can match pattern's char.
                    && (s.charAt(indexOfS) == p.charAt(indexOfP) || p.charAt(indexOfP) == '.')) {
                // pattern's char match zero str's char.
                return isMatchCore(s, indexOfS, p, indexOfP + 2)
                        // pattern's char match one str's char.
                        || isMatchCore(s, indexOfS + 1, p, indexOfP + 2)
                        // pattern's char match multiple str's char.
                        || isMatchCore(s, indexOfS + 1, p, indexOfP);
            } else {
                // two different case(very important):
                // if current str's char can't match pattern's char or str is end,
                // should ignore pattern current char and '*'.
                return isMatchCore(s, indexOfS, p, indexOfP + 2);
            }
        }

        // if next char isn't '*', str current character must match pattern current char or false.
        if (indexOfS != s.length()
                && (s.charAt(indexOfS) == p.charAt(indexOfP) || p.charAt(indexOfP) == '.')) {
            return isMatchCore(s, indexOfS + 1, p, indexOfP + 1);
        } else {
            // two different case(very important):
            // if current str's char can't match pattern's char or str is end,
            // return false.
            return false;
        }
    }

    /**
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(m * n)
     */
    public boolean isMatch2(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        // base case.
        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }
}