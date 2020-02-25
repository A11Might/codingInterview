/**
 * [18-I] 删除链表的节点
 *
 * 题目: 删除链表的节点
 *
 *      给定单向链表的头节点和一个要删除的节点值, 返回删除后的节点的头节点.
 *      (题目保证链表中节点的值互不相同)
 *
 * 思路: 1. 遍历链表同时保存当前节点的前驱节点, 当遇到值等于给定值的节点时, 将其删除.
 *
 *      原题是在 O(1) 时间内删除链表节点: 给定单向链表的头节点和一个节点指针, 在O(1)的时间内删除该节点.
 *      2. 把下一个节点的值复制到需要删除的节点上, 再把下一个节点删除, 相当于将当前需要删除的节点删除了.
 *         (需要额外考虑需要删除的节点是否是尾节点, 当前链表是否只有一个节点)
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
     public ListNode deleteNode1(ListNode head, int val) {
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
         // storage current node's previous node.
         ListNode pre = dummy;
         while (head != null) {
             // when meet node which value equal with val, delete its.
             if (head.val == val) {
                 pre.next = head.next;
                 return dummy.next;
             }
             pre = head;
             head = head.next;
         }

         throw new IllegalArgumentException("Haven't a node which value equal val");
     }

    /**
     * 时间复杂度: O(1) (平均时间复杂度)
     * 空间复杂度: O(1)
     */
     public ListNode deleteNode2(ListNode head, ListNode toBeDeleted) {
         if (head == null || toBeDeleted == null) {
             return null;
         }
         if (toBeDeleted.next != null) {
             // toBeDeleted isn't tail node.
             toBeDeleted.val = toBeDeleted.next.val;
             toBeDeleted.next = toBeDeleted.next.next;
         } else {
             if (head == toBeDeleted) {
                 // toBeDeleted is tail node and list just have one node,
                 // delete the head node.
                 head = null;
             } else {
                 // toBeDeleted is tail node and list have many node,
                 // can only traverse list to delete tail node.
                 ListNode cur = head;
                 while (cur.next != toBeDeleted) {
                     cur = cur.next;
                 }
                 cur.next = null;
             }
         }

         return head;
     }
}