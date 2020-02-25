import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [09] 用两个栈实现队列
 *
 * 题目: 用两个栈来实现一个队列.
 *
 * 思路: 使用两个辅助栈, 一个输入栈IN和一个输出栈OUT. 输入时总是压入栈IN, 输出时将栈IN中的元素全部弹出并压入栈OUT后再从OUT栈中弹出,
 *      这样出栈顺序就和最开始入栈顺序是相同的, 即先进入的元素先退出, 这就是队列的顺序.
 */
class CQueue {
    private Deque<Integer> in;
    private Deque<Integer> out;

    public CQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        // node always push into stack IN.
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            if (in.isEmpty()) {
                // when queue is empty, return -1.
                return -1;
            } else {
                // when stack IN is empty but stack OUT have elements,
                // push all stack OUT's element into stack IN.
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        // pop operate always use to stack OUT.
        return out.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */