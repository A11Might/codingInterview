package oldercode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * [32] 分行从上到下打印二叉树
 * 
 * 题目：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        
        return bfs(pRoot, res);
    }

    ArrayList<ArrayList<Integer>> bfs(TreeNode node, ArrayList<ArrayList<Integer>> res) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            // number of elements in the current level
            int curLevelNum = queue.size();
            for (int i = 0; i < curLevelNum; i++) {
                TreeNode cur = queue.poll();
                // fulfill the current level
                subList.add(cur.val);
                // add child nodes of the current level if it exist
                // in the queue for the next level
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(subList);
        }
        
        return res;
    }
    
}
