/**
 * [68-I] 二叉搜索树的最近公共祖先
 *
 * 题目: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先.
 *      (所有节点的值都是唯一的; p, q 为不同节点且均存在于给定的二叉搜索树中.)
 *
 * 思路: 利用二叉搜索树的特性来判断当前节点是否为公共祖先, 并向可能有公共祖先节点的方向遍历.
 *      两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // if both p and q are greater than parent.
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // if both p and q are lesser than parent.
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // we have found the split point, i.e. the LCA node.
        return root;
    }
}