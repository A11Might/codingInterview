import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [28] 对称的二叉树
 * 
 * 题目: 判断给定二叉树是不是对称的. 如果一棵二叉树和它的镜像一样, 那么它是对称的.
 * 
 * 思路: 判断给定的二叉树的左子树与右子树是否为镜像二叉树即可.
 *      1. 递归, dfs.
 *      2. 迭代, bfs.
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
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricCore(root.left, root.right);
    }

    // if root's left subtree and right subtree is mirroring tree,
    // means the tree root is symmetry binary tree.
    private boolean isSymmetricCore(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetricCore(left.left, right.right)
                && isSymmetricCore(left.right, right.left);
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return bfs(root.left, root.right);
    }

    // if root's left subtree and right subtree is mirroring tree,
    // means the tree root is symmetry binary tree.
    private boolean bfs(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            TreeNode cur1 = queue.poll();
            TreeNode cur2 = queue.poll();
            // judge current left subtree node and right one is equal or not.
            if (cur1 == null && cur2 == null) {
                continue;
            }
            if (cur1 == null || cur2 == null || cur1.val != cur2.val) {
                return false;
            }
            // make the should equal nodes put close,
            // so in the next iteration will be judge them is equal or not.
            // if current node is null, also should be add into queue,
            // in case mix the should equal pair(very important).
            queue.offer(cur1.left);
            queue.offer(cur2.right);
            queue.offer(cur1.right);
            queue.offer(cur2.left);
        }

        return true;
    }
}