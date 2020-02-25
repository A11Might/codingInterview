package oldercode;

/**
 * [50] 字符流中第一个不重复的字符
 * 
 * 题目：实现一个函数用来找出字符流中第一个只出现一次的字符
 * 
 * 思路：用数组存储每个从数据流中读取字符的索引(从1开始)用于取出第一个只出现一次的字符
 *      当前位置无元素，数值为0，当前位置元素重复，数值为-1，当前位置元素只出现一个，数值为字符在字符流中的位置
 */
public class Solution {
    // use array to store current char's index
    // index is char in string's position
    private int[] occurrence = new int[128];
    private int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        // if current char not appeared, store it's index
        // if current char appeared, modify value to -1 for mark this char appear one more times
        if (occurrence[ch] == 0) {
            occurrence[ch] = index;
        } else if (occurrence[ch] > 0) {
            occurrence[ch] = -1;
        }
        // index plus one
        index++;
    }
    
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        // res is result, default is '#' for haven't the char which appear one time 
        // minIndex is current earliest index of char which appear one time
        char res = '#';
        int minIndex = Integer.MAX_VALUE;
        // traverse occurrence array for find earliest index of char which appear one time
        for (int i = 0; i < occurrence.length; i++) {
            if (occurrence[i] > 0 && occurrence[i] < minIndex) {
                res = (char) i;
                minIndex = occurrence[i];
            }
        }

        return res;
    }
}
