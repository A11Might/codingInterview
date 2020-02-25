/**
 * [42] 连续子数组的最大和
 * 
 * 题目: 给定一个数组里有正数也有负数. 数组中的一个或连续多个整数组成一个子数组. 求所有子数组的和的最大值.(要求时间复杂度为 O(n))
 * 
 * 思路: 动态规划: f(i) 表示以 i 个元素结尾的连续子数组的最大和,
 *      状态转移方程:           array[i] if i == 0 or f(i - 1) <= 0;
 *                 f(i) =
 *                            array[i] + f(i - 1) if i != 0 and f(i - 1) > 0.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        // dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            // f(i) = array[i] + f(i - 1) if f(i - 1) > 0
            dp[i] = nums[i - 1];
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            // find largest continuous subarray sum.
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = sum <= 0 ? num : sum + num;
            max = Math.max(max, sum);
        }

        return max;
    }
}