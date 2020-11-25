/**
 * [3] 不修改数组找到重复的数字
 * 
 * 题目: 在一个长度为 n + 1 的数组里的所有数字都在 [1, n]的范围内, 所以数组中至少有一个数字是重复的. 请找出数组中任意一个重复的数字.
 *      但不能修改输入的数组.
 *
 * 思路: 类二分查找, 将数组分为含*一定*包含重复元素部分和*不一定*包含重复元素部分
 */
class Solution {
    /**
     * 时间复杂度: O(n * logn)
     * 空间复杂度: O(1)
     */
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return -1;
        int n = nums.length;
        // from [1, n] to find duplication
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            // duplication is in left part
            if (check(nums, l, mid)) r = mid;
            // duplication is in right part
            else l = mid + 1;
        }
        return l;
    }

    // judge the range of [start, end] has duplication or not
    private boolean check(int[] nums, int st, int ed) {
        int cnt = 0;
        for (int num : nums) {
            if (num >= st && num <= ed) cnt++;
        }
        return cnt > ed - st + 1;
    }
}