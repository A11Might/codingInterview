package oldercode;

import java.util.Stack;

/**
 * [24] 反转链表
 * 
 * 题目：反转链表并输出新链表的表头
 * 
 * 思路：反转链表
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // when reverse current listnode's next point
        // use succ to store current listnode' next listnode
        // incase break list
        ListNode pre = null;
        ListNode cur = head;
        ListNode succ = null;
        while (cur != null) {
            succ = cur.next;
            cur.next = pre;
            pre = cur;
            cur = succ;
        }

        return pre;
    }
}
