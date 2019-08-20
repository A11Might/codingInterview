package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [28] 对称的二叉树
 * 
 * 题目：判断给定二叉树是不是对称的二叉树
 * 
 * 思路：判断对称的二叉树的左子树与右子树是否为镜像二叉树 
 *      1、递归，dfs
 *      2、迭代，bfs
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
    boolean isSymmetrical1(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return dfs(pRoot.left, pRoot.right);
    }

    // if pRoot's left subtree and right subtree is mirroring tree
    // the tree pRoot is symmetry binary tree
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
    
    boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return bfs(pRoot.left, pRoot.right);
    }

    // if pRoot's left subtree and right subtree is mirroring tree
    // the tree pRoot is symmetry binary tree
    private boolean bfs(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            TreeNode cur1 = queue.poll();
            TreeNode cur2 = queue.poll();
            // judge current left subtree node and right one is equal or not
            if (cur1 == null && cur2 == null) {
                continue;
            }
            if (cur1 == null || cur2 == null) {
                return false;
            }
            if (cur1.val != cur2.val) {
                return false;
            }
            // make the should equal nodes put close
            // in the next iteration will be judge is equal or not
            // null should also be add, in case mix the should equal pair(very important)
            queue.offer(cur1.left);
            queue.offer(cur2.right);
            queue.offer(cur1.right);
            queue.offer(cur2.left);
        }

        return true;
    }
}
