/**
 * [58-II] 左旋转字符串
 * 
 * 题目: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部. 请定义一个函数实现字符串左旋转操作的功能.
 * 
 * 思路: 1. (str + str).substring(n, len + n)即为要求的结果.
 *
 *      原题想考察的应该是: 给定一个字符数组, 对这个字符数组进行左旋转操作. 要求额外空间复杂度为 O(1).
 *      2. 将原字符串分为两部分, 第一部分为需要移到后面的字符, 第二部分为剩余的字符.
 *         然后进行三次反转字符串的操作: a. 反转第一部分; b. 反转第二部分; c. 反转整个字符串, 即可实现左旋功能.
 */
class Solution {
    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    public String reverseLeftWords1(String s, int n) {
        if (s.length() == 0 || n == 0) {
            return s;
        }
        int len = s.length();
        // actually move step.
        n %= len;
        // (str + str).substring(n, len + n).
        s += s;
        return s.substring(n, n + len);
    }

    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    public String reverseLeftWords2(String s, int n) {
        if (s.length() == 0 || n == 0) {
            return s;
        }
        int len = s.length();
        // actually move step.
        n %= len;
        // divide string to two parts,
        // and respectively reverse these two parts,
        // finally reverse whole string.
        char[] chrs = s.toCharArray();
        reverse(chrs, 0, n - 1);
        reverse(chrs, n, len - 1);
        reverse(chrs, 0, len - 1);
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