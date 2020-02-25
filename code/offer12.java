/**
 * [12] 矩阵中的路径
 *
 * 题目: 设计一个函数, 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径.
 *
 * 思路: 回溯算法.
 */
class Solution {
    /**
     * 时间复杂度: O((m * n) ^ 2)
     * 空间复杂度: O(m * n)
     */
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int rows = board.length, cols = board[0].length;
        // use visited array to mark matrix's position which has been visited in case revisited.
        boolean[][] visited = new boolean[rows][cols];
        // traverse every position of matrix.
        // if current position's char is equal with word's first char,
        // then start to find path from current position.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        // all chars in word had been find.
        if (index == word.length()) {
            return true;
        }
        // when current position is out of matrix, has been visited;
        // or current position char is's same to current char in word.
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        // continue to find path in four directions.
        for (int[] dir : direction) {
            if (dfs(board, visited, row + dir[0], col + dir[1], word, index + 1)) {
                return true;
            }
        }
        // backtrack:
        // before return upper recursion, must recover visited array as it was.
        visited[row][col] = false;
        return false;
    }
}