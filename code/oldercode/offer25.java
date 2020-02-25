package oldercode;

import java.util.Stack;

/**
 * [25] 合并两个排序的链表
 * 
 * 题目：合成两个单调递增的链表为一条单调不减的链表
 * 
 * 思路：类归并排序
 */
/*
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        // use dummy for easy return merged list's head
        // tail always be the end of current merged list
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        // merge list1 and list2
        // until one of them had run out
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        // merge the rest of list1 or list2
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }

        return dummyHead.next;
    }
}
