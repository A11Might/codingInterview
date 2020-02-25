import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [59-I] 滑动窗口的最大值
 * 
 * 题目: 给定一个数组 nums 和滑动窗口的大小 k, 返回所有滑动窗口中的最大值.
 * 
 * 思路: 使用双端队列存储有可能成为滑动窗口最大值的数值.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] ret = new int[len - k + 1];
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        // initialize the sliding window size to zero.
        int left = 0, right = -1;
        // the window sliding to the right.
        while (right + 1 < nums.length) {
            right++;
            // current element is bigger than its previous element in current window,
            // so previous element can't be the maximum in current window, remove it.
            while (!dq.isEmpty() && nums[right] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(right);
            // if current window has been formed, collect maximum value in the window.
            if (right - left + 1 == k) {
                ret[index++] = nums[dq.peekFirst()];
                // move left border for form the next window.
                left++;
            }
            // because add window element is one by one,
            // so window's first element is in window or out window right now.
            // judge window first element is out or not, keep window's element is valid.
            if (dq.peekFirst() < left) {
                dq.pollFirst();
            }
        }

        return ret;
    }
}