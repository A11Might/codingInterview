package offer;

/**
 * [55] 二叉树的深度
 * 
 * 题目：求二叉树的深度
 * 
 * 思路：dfs(node) = max(dfs(node.left), dfs(node.right)) + 1
 */
/**
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
    public int TreeDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // current tree's depth is 
        // node left and right depth's bigger one 
        // and add 1(the node's depth)
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}
