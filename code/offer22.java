/**
 * [22] 链表中倒数第 k 个节点
 * 
 * 题目: 输入一个链表, 输出该链表中倒数第 k 个节点.
 *      (链表的尾节点是倒数第1个节点)
 * 
 * 思路: 快慢指针: 设链表的长度为 n. 设置两个指针 fast 和 slow, 先让 fast 移动 k 个节点, 然后让 fast 和 slow 同时移动, 可以知道
 *               当 fast 移动到链表结尾(null)时, fast 与 slow 相距 k 个节点, 此时 slow 所在位置就是倒数第 k 个节点.
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head, slow = head;
        // fast pointer is faster than slow about k step.
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }
        // when fast pointer is null but k also bigger than 0,
        // it means this list haven't the countdown k's node so return null.
        if (k > 0) {
            return null;
        }
        // fast and slow pointer move together,
        // until fast pointer move to null,
        // now, slow pointer is the countdown k's node.
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}