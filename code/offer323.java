package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [32] 之字形打印二叉树
 * 
 * 题目：第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印
 *      第三行按照从左到右的顺序打印，其他行以此类推
 * 
 * 思路：BFS
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
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean flag = true;
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            LinkedList<Integer> subList = new LinkedList<>();
            // number of elements in the current level
            int nums = queue.size();
            for (int i = 0; i < nums; i++) {
                TreeNode cur = queue.poll();
                // fulfill the current level
                // maybe change the dirction of store order(base on flag)
                if (flag) {
                    subList.add(cur.val);
                } else {
                    subList.addFirst(cur.val); // <---
                }
                // add child nodes of the current level if it exist
                // in the queue for the next level
                if (cur.left != null) {
                    queue.offer(cur.left);
                } 
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(new ArrayList<>(subList));
            // change the dirction of store order
            flag = !flag;
        }
        return res;
    }
}
