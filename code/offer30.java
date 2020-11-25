import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [30] 包含 min 函数的栈
 * 
 * 题目: 定义栈的数据结构, 请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中, 调用 min, push 及 pop 的时间复杂度都是 O(1).
 * 
 * 思路: 使用辅助栈 min 存储当前的最小值.
 */
class MinStack {

    private Deque<Integer> data;
    private Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    /**
     * 方法一:
     * 数据栈和最小值栈中元素个数相同.
     */
    public void push1(int x) {
        data.push(x);
        // always push current minimum element into min stack.
        if (!min.isEmpty() && min.peek() < x) min.push(min.peek());
        else min.push(x);
    }

    public void pop1() {
        data.pop();
        min.pop();
    }

    /**
     * 方法二:
     * 数据栈中元素大于等于最小值栈中元素个数.
     */
    public void push2(int x) {
        data.push(x);
        // push x into min stack,
        // only when current insert value x is smaller or equal current minimum element.
        if (min.isEmpty()) {
            min.push(x);
        } else if (x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop2() {
        int top = data.pop();
        // when current pop element is equal min stack's top,
        // pop min stack top element.
        if (top == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */