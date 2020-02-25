/**
 * [20] 表示数值的字符串
 *
 * 题目: 实现一个函数用来判断字符串是否表示数值(包括整数和小数)
 *      (字符串 "+100", "5e2", "-123", "3.1416" 和 "-1E-16" 都表示数值,
 *      但是 "12e", "1a3.14", "1.2.3", "+-5" 和 "12e+4.3" 都不是)
 *
 * 思路: 1. 将字符串分为三部分判断, A.Be|EC: A 为数值的整数部分, B 为数值的小数部分, C 为数值的指数部分.
 *                              其中 A 和 C 都是整数(可以有正负号), 而 B 是一个无符号整数.
 *      2. 使用正则表达式进行匹配: []  : 字符集合
 *                             ()  : 分组
 *                             ?   : 重复 0 ~ 1 次
 *                             +   : 重复 1 ~ n 次
 *                             *   : 重复 0 ~ n 次
 *                             .   : 任意字符
 *                             \\. : 转义后的 .
 *                             \\d : 数字
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    // because index is same one in this method,
    // so use global variable to storage index.
    private int index = 0;

    public boolean isNumber1(String s) {
        if (s == null) {
            return false;
        }
        // remove string's space which on both sides.
        s = s.trim();
        boolean isNum = scanInteger(s);
        // if current char is '.', means the next part is decimal.
        if (index < s.length() && s.charAt(index) == '.') {
            index++;
            // .123 is legal; 123. is legal; 123.123 legal,
            // so use (scanUnsignedInteger(s) || isNum) to judge.
            // but can't write like this (isNum || scanUnsignedInteger(s))(important),
            // because if put isNum in the front.
            // when isNum is right scanUnsignedInteger(s) will not be execute,
            // means the part B will not calculate.
            isNum = scanUnsignedInteger(s) || isNum;
        }
        // if current char is 'e' or 'E', means the next part is exponent.
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            index++;
            // .e1 and e1 is illegal; 12e and 12e+5.4 is illegal.
            // so use (isNum && scanInteger(s)) to judge.
            isNum = isNum && scanInteger(s);
        }

        // isNum just can imply string have number as start,
        // only when string's all chars are used and isNum is right can imply string is number.
        return isNum && index == s.length();
    }

    // take away unsigned integer part.
    private boolean scanUnsignedInteger(String s) {
        int i = index;
        while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
            index++;
        }

        return index > i;
    }

    // take away signed integer part.
    private boolean scanInteger(String s) {
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            index++;
        }

        return scanUnsignedInteger(s);
    }

    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    public boolean isNumber2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return s.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}