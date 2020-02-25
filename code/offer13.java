/**
 * [13] 机器人的运动范围
 *
 * 题目: 地上有一个m行和n列的方格. 一个机器人从坐标 (0, 0) 的格子开始移动, 每一次只能向左, 右, 上, 下四个方向移动一格,
 *      但是不能进入行坐标和列坐标的数位之和大于k的格子.
 *
 * 思路: 深度优先遍历, 注意这是计算一共可以到达多少格子, 而不是最远路径.
 */
class Solution {
    /**
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(m * n)
     */
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int movingCount(int m, int n, int k) {
        if (k < 0 || m <= 0 || n <= 0) {
            return -1;
        }
        // use visited array to mark matrix's position which has been visited in case revisited.
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, visited, 0, 0);
    }

    private int dfs(int rows, int cols, int k, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visited[row][col] || !check(row, col, k)) {
            return 0;
        }
        visited[row][col] = true;
        // use integer cnt to storage how much grid can be visited.
        int cnt = 1;
        // visited current position and continue calculate can visited position count from four directions.
        for (int[] dir : direction) {
            cnt += dfs(rows, cols, k, visited, row + dir[0], col + dir[1]);
        }
        // needn't recover visited array.
        // because this question is find how much position can be visited,
        // every position will be allow visited one time most.
        return cnt;
    }

    // check can visited current position or not.
    private boolean check(int a, int b, int k) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        while (b != 0) {
            sum += b % 10;
            b /= 10;
        }

        return sum <= k;
    }
}