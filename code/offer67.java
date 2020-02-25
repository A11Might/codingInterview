/**
 * [67] 把字符串转换成整数
 * 
 * 题目: 将给定字符串转换成一个整数.
 *
 * 思路: 考虑所有情况.
 */
class Solution {
    /**
     * 时间复杂度: O(n) (n 为 str 的长度)
     * 空间复杂度: O(1)
     */
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        // mark number is negative or not.
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            // skip '+' or '-' in begin.
            if (i == 0 && (chr == '+' || chr == '-')) {
                continue;
            }
            // current character isn't valid,
            // stop transfer.
            if (chr < '0' || chr > '9') {
                break;
            }
            // if number is out of limit, directly return.
            if (ret > Integer.MAX_VALUE / 10
                    || (ret == Integer.MAX_VALUE / 10 && chr - '0' > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // calculate number.
            ret = ret * 10 + (chr - '0');
        }

        return isNegative ? -ret : ret;
    }
}