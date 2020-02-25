import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * [45] 把数组排成最小的数
 * 
 * 题目: 将给定数组里所有数字拼接起来排成一个数, 返回能拼接出的所有数字中最小的一个.
 * 
 * 思路: 按排序规则(若 str1 + str2 < str2 + str1, 则str1 排在在前)排序给定数组.
 */
class Solution {
    /**
     * 时间复杂度: O(n * logn)
     * 空间复杂度: O(n)
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        return Arrays.stream(nums).mapToObj(String::valueOf).sorted(
                (str1, str2) -> (str1 + str2).compareTo(str2 + str1)
        ).collect(Collectors.joining());
    }
}