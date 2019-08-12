package offer;

import java.util.ArrayList;

/**
 * [34] 二叉树中和为某一值的路径
 * 
 * 题目：打印出二叉树中节点值的和为输入整数的所有路径
 * 
 * 思路：DFS
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
    public ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) {
            return res;
        }
        FindPathCore(new ArrayList<>(), root, target, 0);
        return res;
    }

    private void FindPathCore(ArrayList<Integer> subList, TreeNode node, int target, int curSum) {
        // calculate current node value to current sum
        // and add current node to sublist
        curSum += node.val;
        subList.add(node.val);
        // if current node is leaf and current sum is equal to target
        // generate one path
        if (node.left == null && node.right == null && curSum == target) {
            res.add(new ArrayList<Integer>(subList));
        }
        // if current node have left, recurve move to left
        if (node.left != null) {
            FindPathCore(subList, node.left, target, curSum);
        }
        // if current node have right, recurve move to right
        if (node.right != null) {
            FindPathCore(subList, node.right, target, curSum);
        }
        // hidden condition: current node is leaf but current sum isn't equal to target
        // when back to upper should remove current node(very important) 
        subList.remove(subList.size() - 1);
    }
}
