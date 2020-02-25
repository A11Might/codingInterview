/**
 * [53-II] 0 ~ n - 1 中缺失的数字
 *
 * 题目: 一个长度为 n - 1 的递增排序数组中的所有数字都是唯一的, 并且每个数字都在范围 0 ~ n - 1 之内. 在范围 0 ~ n - 1 内的 n 个数字中
 *      有且只有一个数字不在该数组中, 返回这个数字.
 *
 * 思路: 因为数组中的元素是排序的, 所以将 0 ~ n - 1 这些数字依次放入数组中, 那么它们的下标与它们的值是相同. 假设此时数字 m 不在数组中, 则
 *      m 之前的数字的下标与它们的值依然相等, 但 m + 1 处在下标为 m 的位置, m + 2 处在下标 m + 1 的位置, 以此类推. 因此问题转化为在排
 *      序数组中找到第一个值和下标不相等的元素的下标.
 *      使用二分查找, 根据中间元素的值与下标是否相等, 将数组分为相等区间和不相等区间, 返回不相等区间的第一个元素的下标.
 */
class Solution {
    /**
     * 时间复杂度: O(logn)
     * 空间复杂度: O(1)
     */
    public int missingNumber(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // divide array to equal section and not equal section.
            if (nums[mid] == mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}