package oldercode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * [59] 滑动窗口的最大值
 * 
 * 题目：给定一个数组和滑动窗口的大小，求所有滑动窗口里数值的最大值
 * 
 * 思路：使用双端队列维护一个滑动窗口
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (size == 0 || size > num.length) {
            return new ArrayList<>();
        }
        Deque<Integer> window = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            // current element is bigger than is's previous element in window
            // so previous element cann't be the maximum in window, delete it
            while (!window.isEmpty() && num[window.getLast()] <= num[i]) {
                window.pollLast();
            }
            window.addLast(i);
            // because add window element is one by one
            // so window's first element is in window or out window right now
            // judge window first element is out or not, keep window's element is valid
            if (i - size == window.getFirst()) {
                window.pollFirst();
            }
            // if window is structured, collect the window's maximum value
            if (i >= size - 1) {
                res.add(num[window.getFirst()]);
            }
        }

        return res;
    }
}
