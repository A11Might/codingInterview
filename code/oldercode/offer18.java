package oldercode;

/**
 * [18] 删除链表中重复的节点
 * 
 * 题目：在一个排序的链表中，删除该链表中重复的结点，返回链表头指针(不是去重)
 * 
 * 思路：1 -> 2 -> 2 -> 3
 *      pre  cur  succ
 *      pre  cur       succ
 *      pre -> succ and cur = succ continue
 */     
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode pre = null;
        ListNode cur = pHead;
        ListNode succ = null;
        while (cur != null) {
            // judge current element have duplication or not
            succ = cur.next;
            boolean flag = false;
            if (succ != null && succ.val == cur.val) {
                flag = true;
            } 
            // if current element have duplication
            // find first not duplicatin element
            // and connect previous node and above node
            if (flag) {
                while (succ != null && succ.val == cur.val) {
                    succ = succ.next;
                }
                // if preivous node is null, means the delete duplication is list head
                // should change the list head to succeed node what is first not duplicatin element
                // and move current node to next
                if (pre == null) {
                    pHead = succ;
                } else {
                    pre.next = succ;
                }
                cur = succ;
            // if current element haven't duplication
            // current node move to next element 
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return pHead;
    }
}
