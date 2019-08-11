package offer;

import java.util.ArrayList;

/**
 * [6] 从尾到头打印链表
 * 
 * 题目：按链表值从尾到头的顺序返回一个ArrayList
 * 
 * 思路：从前往后遍历链表，从后向前加入list即可
 */
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
public class Solution {
    public ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        dfs(listNode);
        return res;
    }

    private void dfs(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        // add current listNode value in the first of list
        res.add(0, listNode.val);
        // recurve dfs to collect the others listNode
        dfs(listNode.next);
    }
}
