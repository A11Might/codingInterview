package offer;

/**
 * [52] 两个链表的第一个公共节点
 * 
 * 题目：找出给定两个链表的第一个公共结点
 * 
 * 思路：从如图遍历即可
 *      1 -> 2 -> 3 -> 
 *           ^         4 -> 5
 *           1 -> 2 ->
 *           ^
 */     
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int lengthp1 = countListLength(pHead1);
        int lengthp2 = countListLength(pHead2);
        ListNode longList = pHead1, shortList = pHead2;
        if (lengthp2 > lengthp1) {
            longList = pHead2;
            shortList = pHead1;
        }
        // offset longer list
        int offset = Math.abs(lengthp1 - lengthp2);
        while (offset != 0) {
            longList = longList.next;
            offset--;
        }
        // traverse longer list and shorter list for find common node
        while (longList != null && shortList != null) {
            if (longList.val == shortList.val) {
                return longList;
            }
            longList = longList.next;
            shortList = shortList.next;
        }

        return null; 
    }

    private int countListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        // 1 -> 2 -> 3 -> 4 -> 5
        //      1 -> 2 -> 4 -> 5
        // 
        // (1 -> 2 -> 3 -> 4 -> 5) -> null -> 1 -> 2 -> 4 -> 5
        //                
        //  1 -> 2 -> 4 -> 5 -> null -> (1 -> 2 -> 3 -> 4 -> 5) 
        //        
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next; 
            p2 = p2 == null ? pHead1 : p2.next; 
        }

        return p1;
    }
}
