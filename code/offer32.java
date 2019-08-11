package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * [32] 从上到下打印二叉树
 * 
 * 题目：二叉树的层次遍历
 * 
 * 思路：使用辅助队列
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
    public ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return res;
    }
}
