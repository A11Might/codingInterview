import java.util.*;

/**
 * [32-III] 之字形打印二叉树
 * 
 * 题目: 按照之字形顺序打印二叉树, 即第一行按照从左到右的顺序打印, 第二层按照从右到左的顺序打印, 第三行再按照从左到右的顺序打印,
 *      其他行以此类推.
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
        boolean flag = true;
        while (!queue.isEmpty()) {
            // number of elements in the current level.
            int size = queue.size();
            LinkedList<Integer> sublist = new LinkedList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                // according to flag to decide storage order.
                // for fulfill the current level's node list.
                if (flag) {
                    sublist.add(cur.val);
                } else {
                    sublist.addFirst(cur.val);
                }
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
            // when traverse the next level,
            // change the direction of storage order.
            flag = !flag;
        }

        return res;
    }
}