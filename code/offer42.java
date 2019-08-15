package offer;

/**
 * [42] 连续子数组的最大和
 * 
 * 题目：给一个数组，返回它的最大连续子序列的和(要求时间复杂度O(n))
 * 
 * 思路：动态规划，f(i)表示以i个元素结尾的子数组的最大和
 *       f(i) = array[i] + f(i - 1) if f(i - 1) > 0
 */
public class Solution { 
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        // f(i) = array[i] + f(i - 1) if f(i - 1) > 0
        for (int i = 1; i < dp.length; i++) {
            dp[i] = array[i];
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
        }

        // find larget subarray sum
        int res = Integer.MIN_VALUE;
        for (int num : dp) {
            System.out.println(num);
            res = Math.max(res, num);
        }
        System.out.println(res);
        return res;
    }
}
