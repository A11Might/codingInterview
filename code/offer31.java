import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [31] 栈的压入, 弹出序列
 * 
 * 题目: 输入两个整数序列, 第一个序列表示栈的压入顺序, 请判断第二个序列是否为该栈的弹出顺序.假设压入栈的所有数字均不相等.
 *      (鉴别栈混洗)
 *
 * 思路: 模拟栈混洗: 使用一个辅助栈, 把输入的第一个序列中的数字依次压入该辅助栈, 并按照第二个序列的顺序依次从该栈中弹出数字.
 */
class Solution {
    /**
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(m + n)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushLen = pushed.length, popLen = popped.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushed.length; pushIndex++) {
            // push 'pushed' array's element into stack in order.
            stack.push(pushed[pushIndex]);
            // when stack's top equal with 'popped' array's current element,
            // pop stack's top and 'popped' array's current index plus one for point the next element.
            // until this two element don't equal again.
            while (popIndex < popLen && !stack.isEmpty()
                    && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}