import java.util.Arrays;

/**
 * [03] 数组中重复的数字
 *
 * 题目: 找出数组中重复的数字
 *
 *      在一个长度为 n 的数组里的所有数字都在 0 到 n - 1 的范围内, 数组中某些数字是重复的, 找出数组中任意一个重复的数字.
 *      (不知道有几个数字是重复的; 也不知道每个数字重复几次)
 *
 * 思路: 1. 将输入数组排序, 从排序的数组中找到重复的数字.
 *      2. 使用哈希表(字符集小的时候可以使用数组)存储已遍历过的数字, 若当前遍历的数字出现过, 则找到重复数字.
 *      3. 遍历数组, 将数字按归位(即将数字 i 放在下标为 i 的位置), 若同一个位置上存在多个数字, 则找到重复数字.
 */
class Solution {
    /**
     * 时间复杂度: O(n * logn)
     * 空间复杂度: O(1)
     */
    public int findRepeatNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // sort array, make same elements to adjacent.
        Arrays.sort(nums);
        // traverse array to judge two adjacent elements is same or not.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        // none of duplication.
        return -1;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // use array to storage number had appeared or not.
        boolean[] appeared = new boolean[nums.length];
        // traverse array nums.
        for (int num : nums) {
            // if current number had appeared, find the duplication.
            if (appeared[num]) {
                return num;
            }
            // use array appeared mark number had appeared.
            appeared[num] = true;
        }

        // none of duplication.
        return -1;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int findRepeatNumber3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // traverse array nums.
        for (int i = 0; i < nums.length; i++) {
            // if current number isn't in it's right position,
            // judge right position's element is same of its or not.
            // if same, find the duplication;
            // if not, swap its and the right position element,
            // then continue while process(judge current element is in it's right position or not).
            while (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    swap(nums, i, nums[i]);
                }
            }
        }

        // none of duplication.
        return -1;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}