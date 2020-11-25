/**
 * [27] 二叉树的镜像
 * 
 * 题目: 返回给定二叉树镜像.
 * 
 * 思路: 遍历给定二叉树的每个节点，并翻转当前遍历的节点的左右子树
 */

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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        // change left and right subtree position,
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        // recursive call mirrorTree to handle left and right subtree.
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}