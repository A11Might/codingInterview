/**
 * [18-II] 删除链表的节点
 * 
 * 题目: 删除链表中的重复节点
 *
 *      在一个排序的链表中, 删除该链表中重复的节点, 返回链表头指针. 例如: 链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 处理后为 1 -> 2 -> 5.
 *
 * 思路: 1. 迭代: 遍历链表, 遇到重复节点则将其删除.
 *         1 -> 2 -> 2 -> 3
 *        pre  cur
 *        pre       cur
 *        pre            cur
 *        pre -> cur  continue
 *       2. 递归(减而治之): f(n) = head + f(n - 1).
 *
 *      原题是去重节点, 例如: 链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 处理后为 1 -> 2 -> 3 -> 4 -> 5.
 *      3. 同方法1:  1 -> 2 -> 2 -> 3
 *                      cur  succ
 *                      cur       succ
 *                      cur -> succ and cur == succ continue
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
    public ListNode deleteDuplication1(ListNode head) {
        // head node may be delete,
        // use dummy node to convenience delete head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        var pre = dummy;
        while (pre.next != null) {
            // if current element have duplication,
            // skip all duplication element to find the last duplication element,
            ListNode cur = pre.next;
            while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            // can judge have duplication element or not in range from pre to cur by if.
            // if pre's successor node is cur, it means haven't duplication.
            // if current element haven't duplication, move previous to the next element and continue loop.
            if (pre.next == cur) pre = cur;
            // if pre's successor node is'n cur, it means haven duplication.
            // if current element have duplication, delete duplication and continue loop
            else pre.next = cur.next;
        }

        return dummy.next;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode succ = pHead.next;
        if (succ.val == pHead.val) {
            // if current element is duplication,
            // skip all duplication element find the first not duplication element,
            // then recursive call deleteDuplication to handle other nodes.
            while (succ != null && succ.val == pHead.val) {
                succ = succ.next;
            }
            return deleteDuplication2(succ);
        } else {
            // if current element isn't duplication,
            // just continue recursive call deleteDuplication to handle other nodes.
            pHead.next = deleteDuplication2(succ);
            return pHead;
        }
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public ListNode deleteDuplication3(ListNode pHead) {
        ListNode cur = pHead;
        ListNode succ = null;
        while (cur != null) {
            succ = cur.next;
            // if current element have duplication,
            // skip all duplication element find the first not duplication element,
            while (succ != null && succ.val == cur.val) {
                succ = succ.next;
            }
            // connect current node and first not duplication element for delete duplication.
            cur.next = succ;
            cur = succ;
        }

        return pHead;
    }
}