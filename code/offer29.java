/**
 * [29] 顺时针打印矩阵
 *
 * 题目: 按照从外向里以顺时针的顺序依次打印出给定矩阵中的每一个数字.
 *
 * 思路: 由外向内顺时针打印矩阵的每一层元素.
 */
class Solution {
    /**
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(1)
     */
    private int[] ret;
    private int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        ret = new int[rows * cols];
        int r1 = 0, c1 = 0, r2 = rows - 1, c2 = cols - 1;
        // from outside to inside print matrix.
        while (r1 <= r2 && c1 <= c2) {
            process(matrix, r1++, c1++, r2--, c2--);
        }

        return ret;
    }

    // print matrix's one lap from (r1, c1) to (r2, c2)
    private void process(int[][] matrix, int r1, int c1, int r2, int c2) {
        // it can handle condition which just have one row or one col.
        // print from (r1, c1) to (r1, c2)
        for (int j = c1; j <= c2; j++) {
            ret[index++] = matrix[r1][j];
        }
        // print from(r1 + 1, c1) to (r2, c2)
        for (int i = r1 + 1; i <= r2; i++) {
            ret[index++] = matrix[i][c2];
        }
        // if current condition isn't just have one row,
        // print from (r2, c2 -1) to (r2, c1)
        if (r1 != r2) {
            for (int j = c2 - 1; j >= c1; j--) {
                ret[index++] = matrix[r2][j];
            }
        }
        // if current condition isn't just have one col,
        // print from (r2 - 1, c1) to (r1 + 1, c1)
        if (c1 != c2) {
            for (int i = r2 - 1; i > r1; i--) {
                ret[index++] = matrix[i][c1];
            }
        }
    }
}