import java.util.*;

/**
 * [32-II] 分行从上到下打印二叉树
 * 
 * 题目: 从上到下按层打印二叉树, 同一层的节点按从左到右的顺序打印, 每一层打印到一行.
 * 
 * 思路: 使用队列来进行层次遍历.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // number of elements in the current level.
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                // fulfill the current level's node list.
                sublist.add(cur.val);
                // add exist child nodes of the current level in the queue,
                // for the next level traverse.
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(new ArrayList(sublist));
        }

        return res;
    }
}