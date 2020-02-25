import java.util.Arrays;

/**
 * [48] 最长不含重复字符的子字符串
 *
 * 题目: 返回给定字符串中最长的不包含重复字符的子字符串的长度.
 *
 * 思路: 滑动窗口.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        int[] preIndex = new int[128];
        Arrays.fill(preIndex, -1);
        // initial window size is zero, [0, -1].
        int left = 0, right = -1;
        int maxLength = 0;
        // expand the right edge,
        // and keep the characters in window don't repeat.
        while (right + 1 < s.length()) {
            char chr = s.charAt(++right);
            // if current character is repeat,
            // update left edge.
            if (preIndex[chr] != -1) {
                left = Math.max(left, preIndex[chr] + 1);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            preIndex[chr] = right;
        }

        return maxLength;
    }
}
