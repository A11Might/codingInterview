/**
 * [36] 二叉搜索树与双向链表
 *
 * 题目: 将给定二叉搜索树转换成一个排序的循环双向链表. 要求不能创建任何新的节点, 只能调整树中节点指针的指向.
 *
 * 思路: 因为要创建排序的链表, 所以中序遍历给定二叉树, 依次将遍历到的节点连接起来.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    // use dummy as the header of the list.
    private Node dummy = new Node(-1);
    // use tail point current list's last node,
    // for connect node to list.
    private Node tail = dummy;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);

        // make list to be a circle.
        Node head = dummy.right;
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        // connect current node to list.
        tail.right = root;
        root.left = tail;
        tail = root;
        dfs(root.right);
    }
}