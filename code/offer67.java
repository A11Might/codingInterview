package offer;

/**
 * [67] 把字符串转换成整数
 * 
 * 题目：将给定字符串转换成一个整数
 *      (数值为0或者字符串不是一个合法的数值则返回0)
 * 
 * 思路：考虑所有情况
 */
public class Solution {
    // global variable status to store string is valid or not
    // use status to judge is string is invalid or equal 0
    public boolean status;
    public int StrToInt(String str) {
        // status default value is false
        // result num default value is 0
        status = false;
        long num = 0;

        // if string is null or empty string, directly return num
        // if string is't null or empty string, judge is minus or not and conversion string to long
        int index = 0;
        if (str != null && !str.trim().equals("")) {
            // minus is the flag of number is minus or not, default false
            boolean minus = false;
            if (str.charAt(index) == '+') {
                index++;
            } else if (str.charAt(index) == '-') {
                minus = true;
                index++;
            }
            num = strToIntCore(str, index, minus);
        }

        // conversion long to int
        return (int) num;
    }

    private long strToIntCore(String str, int index, boolean minus) {
        long num = 0;

        while (index < str.length()) {
            char curChr = str.charAt(index++);
            // judge one char by ont char is number or not
            if (curChr >= '0' && curChr <= '9') {
                // calculate number
                int flag = minus ? -1 : 1;
                num = num * 10 + flag * (curChr - '0');

                // if number is out of limit, directly return
                if ((minus && num < -2147483648) || (!minus && num > 2147483647)) {
                    num = 0;
                    return num;
                }
            } else {
                num = 0;
                return num;
            }
        }

        // mark this string can be conver to number
        status = true;
        return num;
    }
}
