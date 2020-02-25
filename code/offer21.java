/**
 * [21] 调整数组顺序使奇数位于偶数前面
 *
 * 题目: 输入一个整数数组, 实现一个函数来调整该数组中数字的顺序, 使得所有奇数位于数组的前半部分, 所有偶数位于数组的后半部分.
 * (不需要保证奇数和奇数, 偶数和偶数之间的相对位置不变)
 *
 * 思路: 类似快速排序的 partition 过程: 将当前区间分为奇数部分和偶数部分. 遍历数组, 若当前元素是奇数则将其放入奇数区间, 若不是则继续遍历.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int[] exchange(int[] nums) {
        // divide current array to odd section and even section.
        int odd = -1;
        for (int i = 0; i < nums.length; i++) {
            // if current element is odd number,
            // put current element to odd section.
            if ((nums[i] & 1) == 1) {
                swap(nums, i, ++odd);
            }
        }

        return nums;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}