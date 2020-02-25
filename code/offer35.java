import java.util.HashMap;

/**
 * [35] 复杂链表的复制
 * 
 * 题目: 复制含有 next 和 random 指针的复杂链表.
 * 
 * 思路: 1. 维护一个哈希表存储, 原节点和拷贝节点. 然后根据原节点连接各拷贝节点.
 *      2. 在每个链表原始节点后创建新节点后, 复制 random 指针, 最后将这个长链拆分为两个链表.
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        // clone every node in original list.
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // according to original list to connect clone node.
        cur = head;
        while (cur != null) {
            Node clone = map.get(cur);
            clone.next = map.get(cur.next);
            clone.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        // put current node's clone node behind current node.
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // connect clone's random point.
        cur = head;
        while (cur != null) {
            Node clone = cur.next;
            if (cur.random != null) {
                // if current node have random point,
                // so copy random point.
                // clone's random is behind current node's random.
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // divide long list to before and copy one.
        cur = head;
        Node cloneHead = cur.next;
        // niubility operation(respect).
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = next.next;
            cur = next;
        }

        return cloneHead;
    }
}