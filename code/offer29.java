package offer;

import java.util.ArrayList;

/**
 * [29] 顺时针打印矩阵
 * 
 * 题目：从外向里以顺时针依次打印矩阵中每一个数字
 * 
 * 思路：由外向内顺时针打印矩阵的每一层元素
 */

public class Solution {
    // print matrix one lap by one lap from outside to inside
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int a = 0, b = 0;
        int c = matrix.length - 1, d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            process(matrix, res, a++, b++, c--, d--);
        }
        return res;
    }

    // print matrix's one lap pass (a, b) and (c, d)
    private void process(int[][] matrix, ArrayList<Integer> res, int a, int b, int c, int d) {
        // matrix only have one row
        if (a == c) {
            for (int i = b; i <= d; i++) {
                res.add(matrix[a][i]);
            }
        // matrix only have one column
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                res.add(matrix[i][b]);
            }
        // general condition
        } else {
            int curRow = a, curCol = b;
            while (curCol != d) {
                res.add(matrix[curRow][curCol++]);
            }
            while (curRow != c) {
                res.add(matrix[curRow++][curCol]);
            }
            while (curCol != b) {
                res.add(matrix[curRow][curCol--]);
            }
            while (curRow != a) {
                res.add(matrix[curRow--][curCol]);
            }
        }
    }
}
