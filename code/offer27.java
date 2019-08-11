package offer;

/**
 * [27] 二叉树的镜像
 * 
 * 题目：将给定二叉树转化为镜像
 * 
 * 思路：遍历二叉树的每个节点，交换左右子树位置
 */
/**
 * public class TreeNode { 
 *      int val = 0; 
 *      TreeNode left = null; 
 *      TreeNode right = null;
 * 
 *      public TreeNode(int val) { 
 *          this.val = val;
 *      }    
 * }
 */
public class Solution {
    public void Mirror(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode node) {
        // base case
        if (node == null) {
            return;
        }
        // change left and right subtree position
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        // recurve function for left and right subtree
        dfs(node.left);
        dfs(node.right);
    }
}
