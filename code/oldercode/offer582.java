package oldercode;

/**
 * [58] 左旋转字符串
 * 
 * 题目：将给定字符序列S循环左移K位后的序列输出
 * 
 * 思路：1、将原字符串分为两部分，需要移到后面的字符为第一部分，剩余为第二部分
 *      三次反转字符串，a、反转第一部分
 *                     b、反转第二部分
 *                     c、反转整个字符串，实现左旋功能
 *      2、(str + str).substring(n, len + n);
 */
public class Solution {
    public String LeftRotateString1(String str, int n) {
        int len = str.length();
        if (len == 0 || n == 0) {
            return str;
        }

        // actually move step
        n %= len;
        // divide string to two parts [left, mid] and (mid, right]
        // respectively reverse above two parts and total string
        char[] chrs = str.toCharArray();
        int left = 0, mid = n - 1, right = len - 1;
        reverse(chrs, left, mid);
        reverse(chrs, mid + 1, right);
        reverse(chrs, left, right);

        // chars array to string conversion
        return new String(chrs);
    }

    private void reverse(char[] chrs, int start, int end) {
        if (start >= end) {
            return;
        }

        while (start < end) {
            char temp = chrs[end];
            chrs[end--] = chrs[start];
            chrs[start++] = temp;
        }
    }

    public String LeftRotateString(String str, int n) {
        int len = str.length();
        if (len == 0 || n == 0) {
            return str;
        }

        // actually move step
        n %= len;
        // (str + str).substring(n, len + n);
        str += str;
        return str.substring(n, len + n);
    }
}
