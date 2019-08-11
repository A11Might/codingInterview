package offer;

import java.util.Stack;

/**
 * [30] 包含min函数的栈
 * 
 * 题目：实现可以O(1)时间复杂度得到栈中最小值的栈
 * 
 * 思路：使用辅助栈help储存当前最小值
 * https://github.com/A11Might/SomePracticeCode/blob/master/learningCode/GetMinStack.java
 */

public class Solution {
    public Stack<Integer> data = new Stack<>();
    public Stack<Integer> help = new Stack<>();

    public void push(int node) {
        if (help.isEmpty()) {
            help.push(node);
        } else if (help.peek() < node) {
            help.push(help.peek());
        } else {
            help.push(node);
        }
        data.push(node);
    }

    public void pop() {
        data.pop();
        help.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return help.peek();
    }
}
