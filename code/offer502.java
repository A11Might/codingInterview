import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [50-II] 字符流中第一个不重复的字符
 *
 * 题目: 实现一个函数用来找出字符流中第一个只出现一次的字符. 如果当前字符流没有存在出现一次的字符, 返回 '#' 字符.
 *
 * 思路: 1. 用数组存储每个从数据流中读取的字符的索引(从 1 开始, 0 代表当前字符未出现过; 不同字符使用 ascii码 一一映射到整数数组中).
 *         当字符重复出现时, 将数组中的值置为 -1. 这样数组中就保存了只出现一次的字符的索引, 遍历数组找到第一个只出现一次的字符.
 *      2. 用数组统计从字符流中读取的每个字符的出现次数(不同字符使用 ascii码 一一映射到整数数组中), 并将遍历到的字符依次加入到队列中.
 *         不断维护队首元素为第一个只出现一次的字符(不断出队出现多次的字符).
 */
public class Solution {
    /**
     * 方法一
     */
    private int[] occurrence = new int[128];
    // index is the index of current character in stringstream.
    private int index = 1;

    //Insert one char from stringstream
    public void Insert1(char ch) {
        // record current character's first appeared index in stringstream.
        // if current character appeared one more time, record -1 for mark.
        if (occurrence[ch] == 0) {
            occurrence[ch] = index;
        } else if (occurrence[ch] > 0) {
            occurrence[ch] = -1;
        }
        // move index to point next character.
        index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce1() {
        char res = '#';
        int minIndex = Integer.MAX_VALUE;
        // traverse occurrence array for find earliest index of char which appear only one time
        for (int i = 0; i < occurrence.length; i++) {
            if (occurrence[i] > 0 && occurrence[i] < minIndex) {
                res = (char) i;
                minIndex = occurrence[i];
            }
        }

        return res;
    }

    /**
     * 方法二
     */
    private int[] cnts = new int[128];
    private Queue<Character> queue = new ArrayDeque<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        cnts[ch]++;
        queue.offer(ch);
        // maintenance queue head element is the character which first appear only one time.
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
