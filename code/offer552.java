/**
 * [55-II] 平衡二叉树
 * 
 * 题目: 判断给定二叉树树是不是平衡二叉树. 如果某二叉树中任意节点的左右子树的深度相差不超过 1, 那么它就是一棵平衡二叉树.
 * 
 * 思路: 树型 DP.
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
     * 空间复杂度: O(logn)
     */
    public boolean isBalanced(TreeNode root) {
        // use a two element array to storage current tree's message.
        // array[0] represent is balance, 0: is't balance; 1: is balance.
        // array[1] represent tree's height.
        int[] ret = isBalancedCore(root);
        return ret[0] == 1;
    }

    private int[] isBalancedCore(TreeNode root) {
        if (root == null) {
            return new int[] {1, 0};
        }
        // recursive call isBalancedCore to collect left subtree's message,
        // if right subtree isn't balance direct return.
        int[] left = isBalancedCore(root.left);
        if (left[0] == 0) {
            return new int[] {0, 0};
        }
        // same way to right subtree.
        int[] right = isBalancedCore(root.right);
        if (right[0] == 0
                // judge current tree is balance or not.
                || Math.abs(left[1] - right[1]) > 1) {
            return new int[] {0, 0};
        }

        // make current tree's message.
        return new int[] {1, Math.max(left[1], right[1]) + 1};
    }
}