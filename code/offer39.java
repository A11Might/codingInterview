package offer;

/**
 * [39] 数组中出现次数超过一半的数字
 * 
 * 题目：找出数组中出现的次数超过数组长度的一半的数字
 * 
 * 思路：1、改变原数组
 *          数组排序后位于数组中间的数字(数组中第n / 2大的数字)
 *          即为数组中出现的次数超过数组长度的一半的数字
 *          使用快排的partition分割数组，分割位置为n / 2时，找到该数字
 *      2、不改变原数组
 *          数组中出现的次数超过数组长度的一半的数字比其他所有数字出现的
 *          和还要多，所以在遍历数组时保存两个值：一是数组中一个数字，一
 *          是次数，遍历下一个数字时，若它与之前保存的数字相同，则次数加1
 *          否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。遍历
 *          结束后，所保存的数字即为所求
 */
class Solution {
    public int MoreThanHalfNum_Solution1(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int mid = n >> 1;
        // find middle element between start and end
        int start = 0, end = n - 1;
        int index = partition(array, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(array, start, end);
        }
        
        return judgeResult(array, array[index]);
    }

    // divide target range array to smaller a random value part and other
    private int partition(int[] arr, int start, int end) {
        // random selecte one value of target range array as divide value
        swap(arr, start + (int) Math.random() * (end - start + 1), end);
        int smaller = start - 1;
        while (start < end) {
             if (arr[start] < arr[end]) {
                swap(arr, ++smaller, start++);
             } else {
                start++;
             }
        }
        // move end element to right position
        swap(arr, ++smaller, end);
        return smaller;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    // judge result right or not
    private int judgeResult(int[] arr, int res) {
        int n = arr.length;
        int count = 0;
        for (int num : arr) {
            if (num == res) {
                count++;
            }
        }
        return count > (n >> 1) ? res : 0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = array[0], times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                res = array[i];
                times = 1;
            } else if (array[i] == res) {
                times++;
            } else {
                times--;
            }
        }

        return judgeResult(array, res);
    }
}
