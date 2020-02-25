/**
 * [58-I] 翻转单词顺序
 * 
 * 题目: 输入一个英文句子, 翻转句子中单词的顺序, 但单词内字符的顺序不变. 为简单起见, 标点符号和普通字母一样处理.
 *      (无空格字符构成一个单词;
 *      输入字符串可以在前面或者后面包含多余的空格, 但是反转后的字符不能包括;
 *      如果两个单词间有多余的空格, 将反转后单词间的空格减少到只含一个.)
 *
 * 思路: 1. 拆分出每个单词后, 逆序组成字符串.
 *
 *      原题想考察的应该是: 给定一个字符数组, 翻转字符数组中单词的顺序, 标点同普通字母一样处理. 要求额外空间复杂度为 O(1).
 *      2. 两次翻转字符串: a. 反转句子中所有的字符; b. 反转每个单词中字符的顺序.
 */
class Solution {
    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    public String reverseWords1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // split up words in the string.
        String[] strs = s.trim().split(" +");
        // joint this words in reverse order for get a string.
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // remove spaces on both sides of the string,
        // and replace multiple spaces in a string with one.
        char[] chrs = s.trim().replaceAll(" +", " ").toCharArray();
        int len = chrs.length;
        // first, reverse whole string's characters.
        reverse(chrs, 0, len - 1);
        // second, reverse each word's characters.
        int start = 0, end = 0;
        while (end <= len) {
            // tips: end equal n should put in front of end pointer point character is space in case out of index error.
            if (end == len || chrs[end] == ' ') {
                // when end pointer point character is space or end pointer's index equal n,
                // found one word and reverse its characters,
                // then move pointers to find the next word.
                reverse(chrs, start, end - 1);
                start = end + 1;
            }
            end++;
        }

        return new String(chrs);
    }

    // reverse character array from start to end.
    private void reverse(char[] chrs, int start, int end) {
        while (start < end) {
            char temp = chrs[end];
            chrs[end--] = chrs[start];
            chrs[start++] = temp;
        }
    }
}