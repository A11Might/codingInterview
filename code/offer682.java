/**
 * [68-II] 二叉树的最近公共祖先
 *
 * 题目: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先.
 *      (所有节点的值都是唯一的; p, q 为不同节点且均存在于给定的二叉树中.)
 *
 * 思路: 在左右子树中查找是否存在 p 或者 q, 如果 p 和 q 分别在两个子树中, 那么就说明根节点就是最低公共祖先.

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}