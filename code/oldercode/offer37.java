package oldercode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [37] 序列化二叉树
 * 
 * 题目：分别实现二叉树序列化和反序列化
 * 
 * 思路：怎么序列化就怎么反序列化
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
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
  }


    TreeNode Deserialize(String str) {
       String[] values = str.split("!");
       // use queue can order traverse string
       // and don't need to consider what element should be visite
       Deque<String> queue = new ArrayDeque<>();
       for (String value : values) {
           queue.add(value);
       }
       return deserializeCore(queue);
  }

  private TreeNode deserializeCore(Deque<String> queue) {
      String curValue = queue.poll();
      // queue'last element must be "#"
      // so don't need judge queue is empty
      // the recursion can end
      if (curValue.equals("#")) {
          return null;
      }
      TreeNode cur = new TreeNode(Integer.valueOf(curValue));
      cur.left = deserializeCore(queue);
      cur.right = deserializeCore(queue);
      return cur;
  }
}
