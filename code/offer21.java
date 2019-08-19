package offer;

/**
 * [21] 调整数组顺序使奇数位于偶数前面
 * 
 * 题目：调整给定数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分 (并保证奇数和奇数，偶数和偶数之间的相对位置不变)
 * 
 * 思路：类插入排序，保证数组的稳定性(若不要求稳定性，使用快排的partition)
 */     
public class Solution {
    public void reOrderArray(int [] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 != 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j] % 2 == 0) {
                        swap(array, j, j + 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
