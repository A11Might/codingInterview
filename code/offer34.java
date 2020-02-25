import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [34] 二叉树中和为某一值的路径
 *
 * 题目: 返回给定二叉树中节点值的和为输入整数的所有路径. 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径.
 *
 * 思路: 回溯算法.
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
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        dfs(root, new ArrayList<>(), sum);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        // calculate current node value to current sum,
        // and add current node to path.
        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            // if current node is leaf and current sum is equal to target,
            // get one path which path's sum equal sum.
            res.add(new ArrayList(path));
        } else {
            // if current node isn't leaf or current sum isn't equal to target,
            // continue recursive call dfs to find path.
            dfs(root.left, path, sum);
            dfs(root.right, path, sum);
        }
        // backtrack: when back to upper should remove current node(very important).
        path.remove(path.size() - 1);
    }
}