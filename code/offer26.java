package offer;

/**
 * [26] 树的子结构
 * 
 * 题目：判断二叉树B是不是二叉树A的子结构(空树不是任何一个树的子结构)
 * 
 * 思路：node1              node2
 *        1                   1
 *      3   5               3   5
 *     2 4 6 7
 *      遍历A树的每个节点，以可能的子树和B树比较，判断是否为其子树
 *      node2遍历完，则node2是node1的子树，node1遍历完node2还没遍历完，则不是
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
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode node1, TreeNode node2) {
        // node1 == null & node2 == null
        // or node1 != null & node2 == null
        if (node2 == null) {
            return true;
        }
        // node1 == null & node2 != null
        if (node1 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isSubtree(node1.left, node2.left) && isSubtree(node1.right, node2.right);
        } else {
            return false;
        }
    }
}
