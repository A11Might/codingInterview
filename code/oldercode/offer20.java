package oldercode;

/**
 * [20] 表示数值的字符串
 * 
 * 题目：实现一个函数用来判断字符串是否表示数值(包括整数和小数)
 *      (字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值，但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是)
 * 
 * 思路：将字符串分为三部分判断，A为数值的整数部分，B为数值的小数部分，C为数值的指数部分。
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        int[] index = {0};
        // number's integer and decimal part
        // 100.100, 100., .100 all is right
        // . is wrong
        boolean numeric = scanInteger(str, index);
        if (index[0] != str.length && str[index[0]] == '.') {
            index[0]++;
            // should write like this numeric | scanUnsignedInteger(str, index)
            // because if use ||
            // when numeric is right scanUnsignedInteger(str, index) will not be execute
            // the index will not move to next part C, the exponent part cann't be judge
            numeric = numeric | scanUnsignedInteger(str, index);
        }
        // number's exponent part
        if (index[0] != str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            numeric = numeric && scanInteger(str, index);
        }

        // numeric just can imply string have number as start
        // only when string's all chars are used and numeric is right can imply string is number
        return numeric && index[0] == str.length;
    }

    // take away unsigned integer part
    private boolean scanUnsignedInteger(char[] str, int[] index) {
        int i = index[0];
        while (index[0] != str.length && '0' <= str[index[0]] && str[index[0]] <= '9') {
            index[0]++;
        }

        return index[0] > i;
    }

    // take away signed integer part
    private boolean scanInteger(char[] str, int[] index) {
        if (index[0] != str.length && (str[index[0]] == '-' || str[index[0]] == '+')) {
            index[0]++;
        }

        return scanUnsignedInteger(str, index);
    }
}
