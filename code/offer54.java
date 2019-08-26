package offer;

/**
 * [54] 二叉搜素树的第k大节点
 * 
 * 题目：找出给定二叉搜素数的第k大的结点
 * 
 * 思路：中序遍历二叉搜索树
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
*/
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }

        // use array to store k, because all recursion's k is the same one(very important)
        int[] K = {k};
        return kthNodeCore(pRoot, K);
    }

    TreeNode kthNodeCore(TreeNode node, int[] k) {
        if (node == null) {
            return null;
        }
        TreeNode target = kthNodeCore(node.left, k);
        // if from current node's left subtree cann't find kth node
        if (target == null) {
            // judge current node is kth node or not
            // if current node isn't kth node, k - 1
            // and continue find (k - 1)th node in current node's right subtree
            if (k[0] == 1) {
                return node;
            }
            // k - 1 is remain nodes's (k - 1)th(very important)
            k[0]--;
            target = kthNodeCore(node.right, k);
        }
        
        return target;
    }
}
