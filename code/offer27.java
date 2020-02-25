/**
 * [27] 二叉树的镜像
 * 
 * 题目: 返回给定二叉树镜像.
 * 
 * 思路: 反转给定二叉树: 遍历二叉树的每个节点, 交换左右子树位置.
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
        if (root == null) {
            return null;
        }
        // change left and right subtree position,
        // and recursive call mirrorTree to handle left and right subtree.
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);

        return root;
    }
}