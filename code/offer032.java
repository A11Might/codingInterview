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
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // start equal 1 and end equal n
        int start = 1, end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int count = countRange(nums, start, mid);
            // when start equal end, judge start(end) is the duplication or not
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            // duplication is in left part
            if (count > (mid - start + 1)) {
                end = mid;
            // duplication is in right part
            } else {
                start = mid + 1;
            }
        }

        // haven't duplication
        throw new IllegalArgumentException("No Solution");
    }
    
    // count how much number value is between [start, end] in array numbers
    private int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int num : nums) {
            if (start <= num && num <= end) {
                count++;
            }
        }

        return count;
    }
}
