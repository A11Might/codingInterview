package offer;

/**
 * [13] 机器人的运动范围
 * 
 * 题目：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动
 *      每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐
 *      标和列坐标的数位之和大于k的格子
 * 
 * 思路：回溯算法
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        // use visited array to mark grid which had visited
        boolean[] visited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);

        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        // if current grid can pass, pass this grid and continue calculate can pass grid count from four directions 
        if (0 <= row && row < rows && 0 <= col && col < cols && 
            !visited[row * cols + col] &&
            check(threshold, row, col)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                        movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                        movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                        movingCountCore(threshold, rows, cols, row, col + 1, visited);
            // needn't recover visited, because find how much grid can be visited
        }

        return count;
    }

    // check can pass current grid or not 
    private boolean check(int threshold, int row, int col) {
        if (threshold >= getDigitSum(row) + getDigitSum(col)) {
            return true;
        }

        return false;
    }

    // calculate integer's every position nubmer's sum 
    private int getDigitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
