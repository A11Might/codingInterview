/**
 * [04] 二维数组中的查找
 *
 * 题目: 判断矩阵中是否含有整数 target (矩阵中每一行从左往右递增, 每一列从上往下递增).
 *
 * 思路: 从左下角往右上角判断(或从右上角往左下角判断).
 *      1. 若从左下角开始查找, 小于当前元素的数一定不在在其右边, 大于当前元素的数一定不在其上边, 所以可以根据 target 和当前元素的大小关系
 *      来缩小查找区间.
 *      2. 若从右上角往左下角判断同理.
 */
class Solution {
    /**
     * 时间复杂度: O(m + n) (m为矩阵的行数, n为矩阵的列数)
     * 空间复杂度: O(1)
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // search from left bottom to right top.
        int rows = matrix.length, cols = matrix[0].length;
        int row = rows - 1, col = 0;
        while (row >= 0 && col < cols) {
            if (matrix[row][col] == target) {
                // trap target.
                return true;
            } else if (matrix[row][col] < target) {
                // if current element is smaller than target, move right.
                col++;
            } else {
                // if current element is bigger than target, move up.
                row--;
            }
        }

        return false;
    }
}