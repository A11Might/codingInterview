package offer;

/**
 * [12] 矩阵中的路径
 * 
 * 题目：设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 * 
 * 思路：回溯算法
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // use visited array to mark visited position
        // traverse every position, from current position start find path
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, visited, i, j, str, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, boolean[] visited, int row, int col, char[] str, int index) {
        // all char in string is find
        if (index == str.length) {
            return true;
        }
        // if current position is comform to string current char
        // continue to find path in four directions
        boolean hasPath = false;
        if (0 <= row && row < rows && 0 <= col && col < cols &&
            !visited[row * cols + col] && matrix[row * cols + col] == str[index]) {
            visited[row * cols + col] = true;
            index++;
            hasPath = hasPathCore(matrix, rows, cols, visited, row - 1, col, str, index) ||
                      hasPathCore(matrix, rows, cols, visited, row + 1, col, str, index) ||
                      hasPathCore(matrix, rows, cols, visited, row, col - 1, str, index) ||
                      hasPathCore(matrix, rows, cols, visited, row, col + 1, str, index);
            // before return upper recursion, must recover visited to when enter this recursion the visited like
            visited[row * cols + col] = false;
        }

        return hasPath;
    }
}
