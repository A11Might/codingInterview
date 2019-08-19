package offer;

/**
 * [53] 在排序数组中查找数字
 * 
 * 题目：统计一个数字在排序数组中出现的次数
 * 
 * 思路：语义约定，二分查找返回不大于目标元素的最后一个元素
 *              1> 当有多个命中元素时，必须返回最靠后的元素
 *              2> 失败时，应返回小于目标元素的最大者(含哨兵(lo - 1))
 *      二分查找目标元素 - 1的下标加一和目标元素的下标即为目标数字出现范围
 */     
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int n = array.length;
        if (array == null || n == 0) {
            return 0;
        }
        // find target element if success, will return lastPos
        // if failure, will return -1 or n - 1
        // so just need judge n - 1 is target element or not
        // can judge is array contain target element or not
        int lastPos = binarySearch(array, k);
        if (lastPos == -1 || array[lastPos] != k) {
            return 0;
        }
        // find target - 1 for find first target element's pre 
        int firstPosPre = binarySearch(array, k - 1);
        
        return lastPos - firstPosPre;
    }

    // binary search
    // return the last target element or failure
    private int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (target < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }
}
