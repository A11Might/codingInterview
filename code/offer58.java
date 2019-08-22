package offer;

/**
 * [58] 翻转单词顺序
 * 
 * 题目：反转给定英文句子中单词的顺序，单词内字符顺序不变
 *      (标点符号和普通字母一样处理)
 * 
 * 思路：1、两次反转字符串
 *          a、反转句子中所有的字符
 *          b、反转每个单词中字符的顺序
 *      2、取出每个单词后，逆序组成字符串即可
 */
public class Solution {
    public String ReverseSentence1(String str) {
        // when str only have space nowcoder oj want directly return
        if (str.trim().equals("")) {
            return str;
        }
        // first reverse total string's chars
        char[] chrs = str.toCharArray();
        int n = chrs.length;
        reverse(chrs, 0, n - 1);
        int start = 0, end = 0;
        // then reverse every word's chars
        while (start <= n) {
            // when end point's char is space or end point out of array's index
            // find one word to reverse it and move the point to find the next one
            // tips: end equal n should in front of end point's char is space
            //       in case out of index error
            if (end == n || chrs[end] == ' ') {
                reverse(chrs, start, end - 1);
                end++;
                start = end;
            // or just move end point, to find a full word
            } else {
                end++;
            }
        }

        // chars array to string conversion
        return new String(chrs);
    }

    // reverse chars array from start to end
    public void reverse(char[] chrs, int start, int end) {
        if (start >= end) {
            return;
        }

        while (start < end) {
            char temp = chrs[end];
            chrs[end--] = chrs[start];
            chrs[start++] = temp;
        }
    }

    public String ReverseSentence2(String str) {
        // when str only have space nowcoder oj want directly return
        if (str.trim().equals("")) {
            return str;
        }
        // fetch out every word
        String[] words = str.split(" ");
        // use words make string in reversed order
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }

        // stringbuilder to string conversion
        return sb.toString().trim();
    }
}
