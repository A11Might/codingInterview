package oldercode;

/**
 * [35] 复杂链表的复制
 * 
 * 题目：复制含有next和random指针的链表
 * 
 * 思路：在每个链表原始节点后创建新节点后，复制random指针，最后将这个长链拆分为两个链表
 * 
 * Tips：考虑当前节点为倒数长链表的第二个节点，当前节点的克隆节点为长链表的倒数第一个节点
 *       可以处理所有边界条件
 */
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }

    // clone current node behind current position
    private RandomListNode cloneNodes(RandomListNode pHead) {
        RandomListNode cur = pHead;
        RandomListNode succ = null;
        while (cur != null) {
            succ = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = succ;
            cur = succ;
        }

        return pHead;
    }

    // connect clone's random
    private RandomListNode connectRandomNodes(RandomListNode pHead) {
        RandomListNode cur = pHead;
        RandomListNode curClone = null;
        // clone's random is behind current node's random
        while (cur != null) {
            curClone = cur.next;
            // not all of node have random
            // so when node's random is null, set the clone's random null
            // in case nullpoint exception
            curClone.random = cur.random == null ? null : cur.random.next;
            cur = curClone.next;
        }

        return pHead;
    }

    // divide long list to before and copy one
    private RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode pCloneHead = pHead.next; 
        RandomListNode cur = pHead;
        RandomListNode curClone = null;
        while (cur != null) {
            curClone = cur.next;
            cur.next = curClone.next;
            cur = cur.next;
            // when clone is the last one of the long list
            // special handing: clone.next == null(very important)
            curClone.next = cur == null ? null : cur.next;
        }

        return pCloneHead;
    }
}
