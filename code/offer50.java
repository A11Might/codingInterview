/**
 * [50-I] 第一个只出现一次的字符
 * 
 * 题目: 在字符串 s 中找出第一个只出现一次的字符. 如果没有, 返回一个单空格.
 *
 * 思路: 遍历字符串, 使用哈希表或数组记录字符串中每个字符的出现次数, 然后再次遍历字符串, 当当前字符出现次数为 1 时, 返回即可.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        // use array to store char appear times.
        int[] freq = new int[128];
        // first traverse for statistics char appear times.
        for (char chr : s.toCharArray()) {
            freq[chr]++;
        }
        // second traverse for select the first appear ont time char.
        for (char chr : s.toCharArray()) {
            if (freq[chr] == 1) {
                return chr;
            }
        }

        return ' ';
    }
}