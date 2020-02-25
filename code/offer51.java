/**
 * [51] 数组中的逆序对
 *
 * 题目: 若数组中前一个数字大于后面的数字, 则这两个数字组成一个逆序对. 返回给定数组中逆序对的总数.
 *
 * 思路: 先把数组分隔成子数组, 统计出子数组内部的逆序对数目, 然后在统计出两相邻子数组之间的逆序对的数目. 在统计逆序对的过程中对数组进行排序,
 *      可以加快统计速度(统计两有序相邻子数组之间的逆序对的时间复杂度为 O(m + n), 如下 merge 过程). 这个整个过程其实就是归并排序.
 */
class Solution {
    /**
     * 时间复杂度: O(n * logn)
     * 空间复杂度: O(n)
     */
    private int cnt = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int index = 0;
        int p1 = lo, p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            if (nums[p1] <= nums[p2]) {
                temp[index++] = nums[p1++];
            } else {
                // when left part current element p1 is bigger than right part one p2,
                // we can get mid - p1 + 1 inverse pairs in one time.
                // because left part is in order,
                // it means elements which index is bigger than p1 in left part,
                // it's value is also bigger than p1.
                // so all of elements from p1 to mid are bigger than p2,
                // we got mid - p1 + 1 inverse pairs.
                cnt += mid - p1 + 1;
                temp[index++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            temp[index++] = nums[p1++];
        }
        while (p2 <= hi) {
            temp[index++] = nums[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[lo++] = temp[i];
        }
    }
}