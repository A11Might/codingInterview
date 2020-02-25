/**
 * [53-I] 在排序数组中查找数字
 *
 * 题目: 统计一个数字在排序数组中出现的次数.
 *
 * 思路: 二分查找返回不大于目标元素的最后一个元素, 即将数组分为小于等于目标元素的区间和大于目标元素的区间, 返回前一个区间的最后一个元素.
 *      语义约定: a. 当有多个目标元素时, 必须返回最靠后的元素.
 *               b. 失败时, 应返回小于目标元素的最大者(含哨兵 (lo - 1)).
 *      使用二分查找目标元素 -1 得到的下标 +1 和目标元素的下标之间即为目标数字出现范围.
 */
class Solution {
    /**
     * 时间复杂度: O(logn)
     * 空间复杂度: O(1)
     */
    public int search(int[] nums , int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // use binary search to find target element,
        // if success, will return right lastPos,
        // if failure, will return -1 or n - 1,
        // so need judge current return index is right or not.
        int lastPos = binarySearch(nums, target);
        if (lastPos == -1 || nums[lastPos] != target) {
            return 0;
        }
        // find target - 1 for get the first element index in front of target.
        int firstPosPre = binarySearch(nums, target - 1);

        return lastPos - firstPosPre;
    }

    // return the last target element.
    private int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }
}
