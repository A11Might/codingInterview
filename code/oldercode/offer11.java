package oldercode;

/**
 * [11] 旋转数组的最小数字
 * 
 * 题目：输出给定非递减排序的数组的旋转数组的最小元素
 *      (给出的所有元素都大于0，若数组大小为0，请返回0)
 * 
 * 思路：二分搜索，有三种情况，
 *        a、旋转数组第一个数小于最后一个数
 *            说明数组有序，第一个数即为最小值
 *        b、旋转数组第一个数等于最后一个数和中间位置的数
 *            无法判断，需从头遍历
 *        c、正常情况，二分查找
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if (array == null || n == 0) {
            return 0;
        }
        // when array first is bigger or equal last
        // the array is already order, just return first member
        if (array[0] < array[n - 1]) {
            return array[0];
        }
        int start = 0, end = n - 1;
        // when array first is bigger or equal last
        // use binary search the minimum number
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                break;
            }
            int mid = (start + end) >> 1;
            // when below three member is equal
            // can't continue change range for binary search
            // only can traverse array to find the minimum
            if (array[start] == array[end] && array[end] == array[mid]) {
                return minNumberInOrder(array);
            }
            if (array[mid] <= array[end]) {
                end = mid;
            }
            if (array[start] <= array[mid]) {
                start = mid;
            }
        }

        return array[end];
    }

    // find minimum according traverse array
    private int minNumberInOrder(int[] array) {
        int min = array[0];
        for (int num : array) {
            min = Math.min(min, num);
        }

        return min;
    }
}
