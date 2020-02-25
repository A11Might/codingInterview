import java.util.Arrays;

/**
 * [61] 扑克牌中的顺子
 * 
 * 题目: 从扑克牌中随机抽 5 张牌, 判断是不是一个顺子, 即这 5 张牌是不是连续的. 2 ~ 10为数字本身, A 为 1, J 为 11, Q 为 12 K 为 13,
 *      而大, 小王为 0, 可以看成任意数字. A 不能视为 14.
 *
 * 思路: 1. 数组排序后, 判断 0 的个数是否等于其他相邻数字之间的空缺总数.
 *      2. 满足除零外 a. 无重复元素; b. 最大值与最小值之差小于 5, 即为顺子.
 */
class Solution {
    /**
     * 时间复杂度: O(n * logn)
     * 空间复杂度: O(1)
     */
    public boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        // count the number of zeros.
        for (int num : nums) {
            if (num == 0) {
                cnt++;
            }
        }
        // traverse array element except zero,
        // and use zero to complete the continuous card.
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            cnt -= nums[i + 1] - nums[i] - 1;
        }

        return cnt >= 0;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public boolean isStraight2(int[] nums) {
        // use boolean array visited to mark element had visited or not.
        // use max and min to storage nums array's maximum and minimum value except zero.
        boolean[] visited = new boolean[14];
        int max = 0, min = 14;
        // traverse array:
        // judge array have duplication or not except zero,
        // and judge array the different between maximum and minimum value is smaller than five or not.
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (visited[num]) {
                return false;
            }
            visited[num] = true;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (max - min >= 5) {
                return false;
            }
        }

        return true;
    }
}