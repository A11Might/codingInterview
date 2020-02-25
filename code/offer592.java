import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * [59-II] 队列的最大值
 *
 * 题目: 请定义一个队列并实现函数 max_value 得到队列里的最大值, 要求函数 max_value, push_back 和 pop_front 的时间复杂度都是O(1).
 *      若队列为空, pop_front 和 max_value 需要返回 -1.
 *
 * 思路: 本质上是一个求滑动窗口最大值的问题. 将这个队列可以看成是一个滑动窗口, 入队就是将窗口的右边界右移, 出队就是将窗口的左边界右移.
 */
class MaxQueue {
    private Queue<Integer> data;
    private Deque<Integer> max;

    public MaxQueue() {
        data = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public int max_value() {
        if (max.isEmpty()) {
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        data.offer(value);
        // maintain max queue's head element is current data queue's maximum value.
        while (!max.isEmpty() && value > max.peekLast()) {
            max.pollLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int ret = data.poll();
        // maintain max queue's head element is current data queue's maximum value.
        if (ret == max.peekFirst()) {
            max.pollFirst();
        }
        return ret;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */