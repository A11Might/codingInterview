/**
 * [8] 二叉树的下一个节点
 * 
 * 题目: 给定一个二叉树和其中的一个结点, 请找出中序遍历顺序的下一个结点并且返回. 注意, 树中的结点不仅包含左右子结点, 同时包含指向父结点的指针.
 * 
 * 思路: 中序遍历顺序为左-中-右.
 *      a. 当前节点有右节点时, 其后继节点为其右子树的最左节点.
 *      b. 当前节点无右节点时, 则判断其是否为其父节点的左子节点. 若是, 则其后继节点为其父节点; 若不是, 继续向上寻找.
 */

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            // if current node have right subtree,
            // looking for succeed node in it's right subtree.
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            // if current node haven't right subtree,
            // judge it is its parent node's left child node or not.
            // if not, continue looking for upward.
            TreeLinkNode parent = pNode.next;
            while (parent != null && pNode != parent.left) {
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }
}
