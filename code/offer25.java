/**
 * [25] 合并两个排序的链表
 * 
 * 题目: 输入两个递增排序的链表, 合并这两个链表并使新链表中的节点仍然是递增排序的.
 * 
 * 思路: 类似归并排序的 merge 过程, 1. 迭代: 合并两链表, 当其中一个链表中所有节点合并完成后, 将另一个链表剩余节点一并合并.
 *                              2. 迭代: 合并两链表, 直到所有节点都合并完成.
 *                              3. 递归(减而治之): f(n, m) = 1 + (f(n - 1, m) or f(n, m - 1)).
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
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(1)
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // use dummy for easy return merged list's head.
        // tail always be the end of current merged list.
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        // merge l1 and l2,
        // until all of them had run out.
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int v2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (v1 <= v2) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        return dummy.next;
    }

    /**
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(1)
     */
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // use dummy for easy return merged list's head.
        // tail always be the end of current merged list.
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        // merge l1 and l2,
        // until one of them had run out.
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        // merge the rest of l1 or l2.
        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }

        return dummy.next;
    }

    /**
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(m + n)
     */
    public ListNode mergeTwoLists3(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }
}