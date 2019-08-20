package offer;

/**
 * [23] 链表中环的入口节点
 * 
 * 题目：返回给定链表的环的入口结点，若无，则返回null
 * 
 * 思路：快慢指针
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

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        // judge list have cycle or not
        // when fast arrive list end or fast point meet slow point, terminal itration
        // its means no cycle or have cycle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // if fast is in list end, no cycle 
        if (fast == null || fast.next == null) {
            return null;
        }
        // if list have cycle, find into cycle node 
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
