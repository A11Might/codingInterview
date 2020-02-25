/**
 * [47] 礼物的最大价值
 *
 * 题目: 给定一个 m * n 的棋盘的每一格都放有一个礼物(价值大于 0), 从棋盘的左上角开始拿格子里的礼物, 并每次向右或者向下移动一格,
 *      直到到达棋盘的右下角. 返回最多能拿到多少价值的礼物.
 *
 * 思路: 应该用动态规划求解, 而不是深度优先搜索, 深度优先搜索过于复杂, 不是最优解.
 *      动态规划: f(i, j) 表示走到 (i, j) 位置可以获得的最大价值.
 *               状态转移方程: f(i, j) = max(f(i - 1, j), f(i, j - 1)) + grid[i][j].
 */
class Solution {
    /**
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(m * n)
     */
    public int maxValue1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        // initialize first row and column.
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // fill in the dynamic programing form by state transfer equation.
        // state transfer equation: f(i, j) = max(f(i - 1, j), f(i, j - 1)) + grid[i][j].
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }

    /**
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(n) (n 为矩阵的列数)
     */
    public int maxValue2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        // because of f(i, j) only depend on f(i - 1, j) or f(i, j - 1),
        // so can reuse one row array to storage dynamic programing result.
        int[] dp = new int[cols];
        for (int[] values : grid) {
            // the first column position only can come from upper cell,
            // so f(i, 0) = f(i - 1, 0) + grid[i][0], no double.
            dp[0] += values[0];
            // f(i, j) = max(f(i - 1, j), f(i, j - 1)) + grid[i][j] if j > 0.
            for (int j = 1; j < values.length; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + values[j];
            }
        }

        return dp[cols - 1];
    }
}
