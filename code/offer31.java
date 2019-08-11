package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * [31] 栈的压入、弹出序列
 * 
 * 题目：pushA为压入栈的顺序，判断popA是否是pushA的压入弹出序列(鉴别栈混洗)
 * 
 * 思路：使用辅助栈模拟
 */
public class Solution { 
    // simulate push and pop operate
    public boolean IsPopOrder1(int [] pushA,int [] popA) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int num : pushA) {
            // orderly push pushA's element into stack
            stack.push(num);
            // when stack's top equal with popA's cur element
            // pop stack's top and popA's cur element move to next
            // until this two element don't equal againt
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }

    // simulate the operation in depth(Stack mixed wash)
    // http://note.youdao.com/noteshare?id=bfa62376c92702c48fc60bf7308f957c&sub=91804C2F369544108E1D83263DB4A621
    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        Deque<Integer> stack = new ArrayDeque<>();
        int indexpush = 0, indexpop = 0;
        while (indexpop < popA.length) {
            while (indexpush < pushA.length && pushA[indexpush] != popA[indexpop]) {
                stack.push(pushA[indexpush++]);
            }
            if (indexpush < pushA.length && pushA[indexpush] == popA[indexpop]) {
                stack.push(pushA[indexpush++]);
            }
            if (stack.pop() != popA[indexpop++]) {
                return false;
            }
        }
        return true;
    }
}
