package offer;

/**
 * [55] 二叉树的深度
 * 
 * 题目一：求二叉树的深度
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

/**
 * [55] 平衡二叉树
 * 
 * 题目二：判断二叉树是否是平衡二叉树
 * 
 * 思路：树型dp(后序遍历)
 */
public class Solution {
    public boolean IsBalanced_Solution1(TreeNode root) {
        // use isB to store all subtree is balance or not
        // when one of all subtree isn't balance direct return
        boolean[] isB = {true};
        IsBalanced_SolutionCore(root, 1, isB);
        return isB[0];
    }

    private int IsBalanced_SolutionCore(TreeNode node, int level, boolean[] isB) {
        if (node == null) {
            return level;
        }
        // recurve collect left subtree's message 
        // if right subtree isn't balance direct return
        int leftL = IsBalanced_SolutionCore(node.left, level + 1, isB);
        if (!isB[0]) {
            return level;
        }
        // same to right subtree
        int rightL = IsBalanced_SolutionCore(node.right, level + 1, isB);
        if (!isB[0]) {
            return level;
        }
        // judge current tree is balance or not
        if (Math.abs(leftL - rightL) > 1) {
            isB[0] = false;
        }
        return Math.max(leftL, rightL);
    }
}
