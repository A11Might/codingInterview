/**
 * [54] 二叉搜素树的第k大节点
 *
 * 题目: 返回给定二叉搜索树中第 k 大的节点.
 *
 * 思路: 二叉搜索树的中序遍历序列是升序的, 所以只要将其左中右的遍历顺序改为右中左, 其遍历序列就会变成降序,
 *      此时遍历 k 个节点即可得到第 k 大的节点.
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
    private int cnt = 0;
    private int ret = 0;

    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return ret;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        // traversal order is right to mid to left.
        inorder(root.right, k);
        cnt++;
        if (cnt == k) {
            ret = root.val;
            return;
        }
        inorder(root.left, k);
    }
}