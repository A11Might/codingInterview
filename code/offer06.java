import java.util.*;

/**
 * [06] 从尾到头打印链表
 *
 * 题目: 按链表值从尾到头的顺序返回一个整数类型的数组.
 *
 * 思路: 1. 反转链表后再从头到尾输出.
 *      2. 从头到尾遍历链表并将值存入栈中, 再从栈中依次弹出元素, 输出的节点顺序即为从尾到头.
 *      3. 使用递归栈完成上方法2: 每次访问一个节点时, 先递归输出它后面的节点, 再输出该节点.
 *      4. 从头到尾遍历链表, 每次将节点值放在LinkedList第一个节点位置.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // count list's node number.
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // first, reverse list.
        // second, traverse list to storage value.
        // finally, reverse list again to recover list.
        head = reverseList(head);
        int[] ret = new int[len];
        int index = 0;
        cur = head;
        while (cur != null) {
            ret[index++] = cur.val;
            cur = cur.next;
        }
        reverseList(head);

        return ret;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while (head != null) {
            ListNode succ = head.next;
            cur.next = pre;
            pre = cur;
            cur = succ;
        }

        return pre;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // traverse list and use stack to storage value.
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ret = new int[stack.size()];
        int index = 0;
        // pop element from stack and storage its into array ret.
        // the order is from end to first.
        while (!stack.isEmpty()) {
            ret[index++] = stack.pop();
        }

        return ret;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private int[] ret;
    private int index = 0;

    public int[] reversePrint3(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // count list's node number.
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // use recursive stack to collect element.
        ret = new int[len];
        dfs(head);

        return ret;
    }

    private void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        // recursive call dfs to collect the others listNode from end to first.
        dfs(head.next);
        // then add current listNode value.
        // because its is the first node of list,
        // will be put into last index in the array ret.
        ret[index++] = head.val;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int[] reversePrint4(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            // every element will be put in the first of LinkedList,
            // finally the element order is from end to first.
            list.addFirst(head.val);
            head = head.next;
        }
        // use array ret to storage value in LinkedList for return.
        int[] ret = new int[list.size()];
        int index = 0;
        for (int num : list) {
            ret[index++] = num;
        }

        return ret;
    }
}