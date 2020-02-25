package oldercode;

/**
 * [5] 替换空格
 * 
 * 题目：将字符串的空格替换成 "%20"
 * 
 * 思路：1、从后往前遍历字符串，进行空格替换(避免多次重复移动字符)
 *      2、从前往后遍历字符串，使用StringBuilder重新拼接字符串
 */
public class Solution {
    public String replaceSpace1(StringBuffer str) {
        int spaceNum = 0;
        // count space's number
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        int oldLength = str.length() - 1;
        int newLength = str.length() + spaceNum * 2;
        // reset str's length incase nullpoint
        str.setLength(newLength);
        int newIndex = newLength - 1;
        // traverse str's char in reverse order
        // when current char is ' ' respective 
        // add '0', '2' and '%' to new position from back to front
        // otherwise add current char to new position
        for (int i = oldLength; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(newIndex--, str.charAt(i)); 
            } else {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }
        }

        return str.toString();
    }

    public String replaceSpace2(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        // traverse str's char in order
        // when current char is ' ' add '%20' to stringbuilder
        // otherwise add current char to stringbuilder
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                sb.append("%20");
            }
        }

        return sb.toString();
    }
}
