/**
 * [29] 顺时针打印矩阵
 *
 * 题目: 按照从外向里以顺时针的顺序依次打印出给定矩阵中的每一个数字.
 *
 * 思路: 我们顺时针定义四个方向：右下左上。
 *      从左上角开始遍历，先往右走，走到不能走为止，然后更改到下个方向，再走到不能走为止，依次类推，直到遍历 n ^2 个格子后停止。
 */
class Solution {
    /**
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(1)
     */
    // four directions: right, down, left, up
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[] {};
        int n = matrix.length, m = matrix[0].length;
        int[] ret = new int[n * m];
        boolean[][] st = new boolean[n][m];
        // from (0, 0) to traverse matrix until all position is done
        for (int i = 0, j = 0, idx = 0, d = 0; idx < n * m;) {
            ret[idx++] = matrix[i][j];
            st[i][j] = true;
            int x = i + dir[d][0], y = j + dir[d][1];
            // if current position is out of border
            // change direction to next one and continue traverse
            if (x < 0 || x >= n || y < 0 || y >= m || st[x][y]) {
                d = (d + 1) % 4;
                x = i + dir[d][0];
                y = j + dir[d][1];
            }
            i = x;
            j = y;
        }
        return ret;
    }
}