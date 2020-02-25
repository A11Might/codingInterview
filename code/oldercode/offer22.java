package oldercode;

/**
 * [22] 链表中倒数第k个节点
 * 
 * 题目：返回链表中倒数第k个结点
 * 
 * 思路：使用快慢指针
 */
/*
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // fast point is faster than slow about k
        // when fast is null and it continue to move
        // so the list haven't the last k return null 
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        // fast and slow point move together
        // until fast point move to null
        // so slow point is the last k now
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
