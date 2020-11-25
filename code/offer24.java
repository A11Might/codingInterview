/**
 * [24] 反转链表
 * 
 * 题目: 输入一个链表的头节点, 反转该链表并输出反转后链表的头节点.
 * 
 * 思路: 反转链表, 1. 迭代.
 *               2. 递归.
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        // when reverse current listNode's next point,
        // use succ to storage current listNode's next listNode,
        // in case break list.
        ListNode pre = null, cur = head, succ = null;
        while (cur != null) {
            succ = cur.next;
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
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode succ = head.next;
        // recursive call reverseList2 to solve rest list,
        // then reverse current head node.
        ListNode newHead = reverseList2(succ);
        succ.next = head;
        head.next = null;
        return newHead;
    }
}