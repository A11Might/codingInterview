/**
 * [57-I] 和为 s 的数字
 * 
 * 题目: 给定一个递增排序的数组和一个数字 s, 在数组中查找两个数, 使得它们的和正好是 s. 如果有多对数字的和等于 s, 则输出任意一对即可.
 * 
 * 思路: 由于是递增排序数组, 使用头尾双指针分别指向数组中的最小值和最大值, 假设两指针指向的元素和为 sum, 若 sum == target, 则找到一对;
 *      若 sum > target, 则移动尾指针使 sum 变小; 若 sum < target, 则移动头指针使 sum 变大.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // when head pointer value plus tail pointer value equal with sum,
                // we found the number pair.
                return new int[] {nums[left], nums[right]};
            } else if (sum > target) {
                // when head pointer value plus tail pointer value bigger than sum,
                // move tail point for decrease current sum.
                right--;
            } else {
                // when head pointer value plus tail pointer value smaller than sum,
                // move tail point for increase current sum.
                left++;
            }
        }

        throw new IllegalArgumentException("No Solution");
    }
}