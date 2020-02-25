package oldercode;

/**
 * [4] 二维数组的查找
 * 
 * 题目：判断矩阵中是否含有整数target(矩阵中每一行从左往右递增，每一列从上往下递增)
 * 
 * 思路：从左下角往右上角判断(或从右上角往左下角判断)
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length - 1, col = array[0].length - 1;
        // from left bottom to right top
        int curRow = array.length - 1, curCol = 0;
        while (curRow >= 0 && curCol <= col) {
            // if target is bigger than cur element
            // move right
            if (array[curRow][curCol] < target) {
                curCol++;
            // if target is smaller than cur element
            // move up
            } else if (target < array[curRow][curCol]) {
                curRow--;
            // trap target
            } else {
                return true;
            }
        }

        return false;
    }
}
