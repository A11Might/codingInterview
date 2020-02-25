/**
 * [52] 两个链表的第一个公共节点
 * 
 * 题目: 返回给定两个链表的第一个公共节点. 如果两个链表没有交点，返回 null.
 *      (可假定整个链表结构中没有循环)
 *
 * 思路: 1. 修正长链使得两链表剩余节点数相同, 然后同时遍历两链表, 来找到公共节点.
 *          1 -> 2 -> 3
 *               ^      -> 4 -> 5
 *               1 -> 2
 *               ^
 *      2. 同时遍历两链表, 当其中一条链表到达链尾时, 将其指向另一条链表的头节点继续遍历, 这样就能同时遍历到公共节点.
 *         原链表有公共节点时:
 *         1 -> 2 -> 3
 *                     -> 4 -> 5
 *              1 -> 2
 *
 *         遍历顺序如下:
 *         1 -> 2 -> 3 -> 4 -> 5 -> null -> 1 -> 2 -> 4 -> 5
 *                                                    ^
 *         1 -> 2 -> 4 -> 5 -> null -> 1 -> 2 -> 3 -> 4 -> 5
 *                                                    ^
 *         原链表没有公共节点时:
 *         1 -> 2-> 3
 *
 *         1 -> 2
 *
 *         遍历顺序为:
 *         1 -> 2 -> 3 -> null -> 1 -> 2 -> null
 *                                           ^
 *         1 -> 2 -> null -> 1 -> 2 -> 3 -> null
 *                                           ^
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(1)
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int offset = 0;
        ListNode cur = headA;
        while (cur != null) {
            offset++;
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            offset--;
            cur = cur.next;
        }
        ListNode longList = headA, shortList = headB;
        if (offset < 0) {
            longList = headB;
            shortList = headA;
        }
        // offset longer list.
        offset = Math.abs(offset);
        while (offset-- > 0) {
            longList = longList.next;
        }
        // traverse long list and short list together for find common node.
        while (longList != null && shortList != null
                && longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }

        if (longList == null || shortList == null) {
            return null;
        }

        return longList;
    }

    /**
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(1)
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            // when current pointer arrive the end of list,
            // point current pointer to the other list's head,
            // and continue traverse.
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }

        return l1;
    }
}