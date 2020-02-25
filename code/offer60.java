/**
 * [60] n 个骰子的点数
 *
 * 题目: 把 n 个骰子扔在地上, 所有骰子朝上一面的点数之和为 s. 输入 n, 打印出 s 的所有可能的值出现的概率.
 *      (你需要用一个浮点数数组返回答案, 其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率.)
 *
 * 思路: 1. 回溯所有情况, 统计不同骰子和出现次数.
 *      2. 动态规划, 当 i > 1 时, i 个骰子掷出的数字和由前 i - 1 个骰子掷出数字和和第 i 个骰子掷出的数字决定.
 *      状态表示: f(i, j) 表示前 i 个骰子产生点数 j 的次数;
 *      状态转移方程: f(i, j) = f(i - 1, j - 1) + f(i - 1, j - 2) + ... + f(i - 1, j - k), 其中 k <= 骰子的面数 && k <= j,
 *      因为不可能掷出负数和.
 */
class Solution {
    /**
     * 时间复杂度: O(6 ^ n)
     * 空间复杂度: O(n)
     */
    private int[] freq;

    public double[] twoSum1(int n) {
        int face = 6;
        int maxSum = n * face;
        // use array to storage i dices' every points sum appeared times.
        freq = new int[maxSum - n + 1];
        dfs(n, 0, 0);

        // calculate the probability of each points sum.
        double totalNum = Math.pow(face, n);
        double[] ret = new double[n * face - n + 1];
        for (int i = 0; i < freq.length; i++) {
            ret[i] = freq[i] / totalNum;
        }

        return ret;
    }

    // backtrack i dices' every condition.
    private void dfs(int n, int index, int curSum) {
        if (index == n) {
            freq[curSum - n]++;
            return;
        }
        // current dice point can be 1 to 6, chose one,
        // then recursive call dfs to solve rest dices condition.
        for (int i = 1; i <= 6; i++) {
            dfs(n, index + 1, curSum + i);
        }
    }

    /**
     * 时间复杂度: O(n ^ 2)
     * 空间复杂度: O(n ^ 2)
     */
    public double[] twoSum2(int n) {
        // current dice has six faces.
        int face = 6;
        int maxSum = n * face;
        int[][] dp = new int[n + 1][maxSum + 1];
        // base case:
        // when just have one dice, every face only appeared one time.
        for (int j = 1; j <= face; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // i dices' points sum is equal to i at least.
            // i dices' points sum is equal to the number of dices product the number of faces at most.
            for (int j = i; j <= i * face; j++) {
                // k is current dice's point.
                for (int k = 1; k <= face && k <= j; k++) {
                    // state transfer equation:
                    // f(i, j) = f(i - 1, j - 1) + f(i - 1, j - 2) + ... + f(i - 1, j - k)
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        // number of n dices' possible condition.
        double totalNum = Math.pow(face, n);
        // number of type of n dices' points sum.
        double[] ret = new double[n * face - n + 1];
        // calculate the probability of each points sum.
        for (int j = n; j <= maxSum; j++) {
            ret[j - n] = dp[n][j] / totalNum;
        }

        return ret;
    }

    /**
     * 时间复杂度: O(n ^ 2)
     * 空间复杂度: O(n)
     */
    public double[] twoSum3(int n) {
        int face = 6;
        int maxSum = n * face;
        // reuse array to storage dynamic programing result.
        int[][] dp = new int[2][maxSum + 1];
        for (int j = 1; j <= face; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // use i % 2 to calculate row which will reuse.
            int curRow = i % 2;
            // before reuse, should clear array.(important)
            for (int j = 0; j <= n * face; j++) {
                dp[curRow][j] = 0;
            }
            // other same to upper method.
            for (int j = i; j <= i * face; j++) {
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[curRow][j] += dp[1 - curRow][j - k];
                }
            }
        }

        double totalNum = Math.pow(face, n);
        double[] ret = new double[n * face - n + 1];
        for (int j = n; j <= maxSum; j++) {
            // use n % 2 to calculate the row which current using.
            ret[j - n] = dp[n % 2][j] / totalNum;
        }

        return ret;
    }
}