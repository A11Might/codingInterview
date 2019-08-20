package offer;

/**
 * [8] 二叉树的下一个节点
 * 
 * 题目：给定一个二叉树和其中的一个结点，找出中序遍历顺序的下一个结点
 *      (树中的结点不仅包含左右子结点，同时包含指向父结点的指针)
 * 
 * 思路：a、当前节点有右节点，则后继节点为其右子树最左节点
 *       b、当前节点无右节点，则判断其是否为其父节点的左节点
 *          若是，则其后继节点为其父节点
 *          若不是，继续向上寻找
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
public class Solution { // {8,6,10,5,7,9,11},8
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // if target node have right subtree
        // find succeed node in right subtree
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        // if target node haven't right subtree 
        // judge it is its parent node's left subnode or not
        } else {
            TreeLiknNode parent = pNode.next;
            while (parent != null && parent.left != pNode) {
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }
}
