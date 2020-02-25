package oldercode;

import java.util.Stack;

/**
 * [9] 用两个栈实现队列
 * 
 * 题目：用两个栈来实现一个队列
 * 
 * 思路：使用两个辅助栈，一个输入栈一个输出栈
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        // node always push in stack1
        stack1.push(node);
        // when stack2 is empty
        // push all stack1's element to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
    
    public int pop() {
        // pop operate always pop stack2
        int res = stack2.pop();
        // when stack2 is empty
        // push all stack1's element to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return res;
    }
}
