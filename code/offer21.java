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
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            // if current element is uneven number
            // judge its previous element is even number or not
            // if previous element is even number swap current element and previous(actually not swap)  
            // continue judge current element previous until it's a uneven number
            if (array[i] % 2 != 0) {
                int value = array[i];
                int cur = i;
                while (cur > 0 && (array[cur - 1] % 2 == 0)) {
                    array[cur] = array[cur - 1];
                    cur--;
                }
                array[cur] = value;
            }
        }
    }
}
