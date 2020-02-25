/**
 * [11] 旋转数组的最小数字
 *
 * 题目: 输出给定非递减排序的数组的旋转数组的最小元素.
 *      (给出的所有元素都大于0)
 *
 * 思路: 二分查找, 旋转排序数组可以拆分为两个排序数组 nums1 和 nums2, 并且 nums1任意元素 >= nums2 任意元素,
 *      使用二分查找这两个数组的分界点(nums2 的首元素)即最小元素.
 *      1. 将原数组划分为大于 nums[hi] 部分和小于等于 nums[i] 部分, 最后返回小于等于部分的第一个个元素. 但若数组元素允许重复, 会出现
 *         一个特殊的情况: nums[lo] == nums[mid] == nums[hi], 此时无法确定解在哪个区间, 直接顺序查找.
 *      2. 根据 nums[mid] 和 nums[hi] 的大小判断最小元素所在区间. 但若数组元素允许重复, 会出现 nums[mid] == nums[hi] 的情况, 此
 *         时无法判断最小元素所在区间(例: [1, 0, 1, 1, 1], [1, 1, 1, 0, 1]). 此时采用 hi = hi - 1 的解决方法, 此操作不会丢失最
 *         小值.
 */
class Solution {
    /**
     * 时间复杂度: O(logn) (在特例情况下会退化到 O(n) (如[1, 1, 1, 1]))
     * 空间复杂度: O(1)
     */
    public int minArray1(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            // divide section [lo, hi] to bigger than hi part and smaller or equal hi part.
            // when numbers[lo] == numbers[mid] numbers[hi],
            // can't judge, only to traverse section to find smallest element.
            if (numbers[lo] == numbers[mid] && numbers[mid] == numbers[hi]) {
                return minNumber(numbers, lo, hi);
            } else if (numbers[mid] <= numbers[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return numbers[lo];
    }

    private int minNumber(int[] numbers, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[lo];
    }

    /**
     * 时间复杂度: O(logn) (在特例情况下会退化到 O(n) (如[1, 1, 1, 1]))
     * 空间复杂度: O(1)
     */
    public int minArray2(int[] numbers) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            // when mid's value is bigger than hi,
            // mid must be in left section and the smallest element is in mid's right.
            if (numbers[mid] > numbers[hi]) {
                lo = mid + 1;
            } else if (numbers[mid] < numbers[hi]) {
                // when mid's value is smaller than hi,
                // mid must be in right section and the smallest element maybe is mid.
                hi = mid;
            } else {
                // when mid's value is equal with hi,
                // we can't judge mid is belong to which section, such as [1, 0, 1, 1, 1], [1, 1, 1, 0, 1].
                // so let hi = hi - 1 to solve this problem.
                hi--;
            }
        }

        return numbers[lo];
    }
}