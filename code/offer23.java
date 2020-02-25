/**
 * [23] 链表中环的入口节点
 * 
 * 题目: 给一个链表, 若其中包含环, 返回该链表的环的入口结点, 否则, 输出 null.
 * 
 * 思路: Floyd 算法, 找出列表中是否有环, 如果没有环, 可以直接返回 null 并退出. 否则, 用相遇节点来找到环的入口.
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
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode fast = pHead, slow = pHead;
        // judge list have cycle or not.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // if fast pointer point the end of list, means list haven't cycle.
        if (fast == null || fast.next == null) {
            return null;
        }
        // if list have cycle, find into cycle's node.
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
