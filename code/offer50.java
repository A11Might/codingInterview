package offer;

/**
 * [50] 第一个只出现一次的字符
 * 
 * 题目：在给定字符串中找到第一个只出现一次的字符，并返回它的位置，若没有则返回-1
 *      (给定字符串只包含字母，区别大小写)
 * 
 * 思路：遍历字符串，使用哈希表或数组记录字符串中每个字符的出现次数
 *       再遍历字符串，当当前字符出现次数为1时，返回即可
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int n = str.length();
        if (str == null || n == 0) {
            return -1;
        }
        // use array to store char appear times
        int[] times = new int[256];
        // first traverse for statistics char appear times
        for (int i = 0; i < n; i++) {
            times[(int) str.charAt(i)]++;
        }
        // second traverse for select the first appear ont time char
        for (int i = 0; i < n; i++) {
            if (times[(int) str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
