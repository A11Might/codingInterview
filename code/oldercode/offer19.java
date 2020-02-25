package oldercode;

/**
 * [19] 正则表达式匹配
 * 
 * 题目：实现一个函数用来匹配包括'.'和'*'的正则表达式
 *      (模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次(包含0次))
 * 
 * 思路：考虑所有情况(回溯？)
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int indexStr, char[] pattern, int indexPattern) {
        // match success
        if (indexStr == str.length && indexPattern == pattern.length) {
            return true;
        }
        // match defeat
        if (indexStr != str.length && indexPattern == pattern.length) {
            return false;
        } 
        // can't estimate match condition
        // three case, str is end but pattern maybe remain char* could be delete, continue judge(very important)
        // four case, str isn't end and pattern isn't end, continue judge

        // if next char is '*'
        if (indexPattern + 1 < pattern.length && pattern[indexPattern + 1] == '*') {
            // if current str's char can match pattern's char
            if ((indexStr !=str.length && str[indexStr] == pattern[indexPattern]) || 
                (pattern[indexPattern] == '.' && indexStr !=str.length)) {
                return matchCore(str, indexStr, pattern, indexPattern + 2) || // pattern's char match zeor str's char
                       matchCore(str, indexStr + 1, pattern, indexPattern + 2) || // pattern's char match one str's char
                       matchCore(str, indexStr + 1, pattern, indexPattern); // pattern's char match one more str's char
            // two case(very important)
            // if current str's char cann't match pattern's char or str is end ignore pattern current char and '*'
            } else {
                return matchCore(str, indexStr, pattern, indexPattern + 2);
            }
        }

        // if next char isn't '*', str current char must match pattern current char or false 
        if ((indexStr !=str.length && str[indexStr] == pattern[indexPattern]) || 
            (pattern[indexPattern] == '.' && indexStr !=str.length)) {
            return matchCore(str, indexStr + 1, pattern, indexPattern + 1);
        } else {
            return false;
        }
    }
}
