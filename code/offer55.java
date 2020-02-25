/**
 * [55-I] 二叉树的深度
 * 
 * 题目: 返回给定二叉树的深度. 从根节点到叶节点依次经过的节点(含根, 叶节点)形成树的一条路径, 最长路径的长度为树的深度.
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
     * 空间复杂度: O(n)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // current tree's depth equal the larger of the left and right subtrees plus one.
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}