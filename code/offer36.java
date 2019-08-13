package offer;

/**
 * [36] 二叉搜索树与双向链表
 * 
 * 题目：将二叉搜索树转换成一个排序的双向链表(不能新建节点)
 * 
 * 思路：中序遍历
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
    // lastNodeOfList at anytime is the same one(very important)
    public TreeNode lastNodeOfList = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convertCore(pRootOfTree);
        // find list first treenode
        TreeNode firstNodeOfList = pRootOfTree;
        while (firstNodeOfList.left != null) {
            firstNodeOfList = firstNodeOfList.left;
        }
        return firstNodeOfList;
    }

    private void convertCore(TreeNode root) {
        if (root == null) {
            return;
        }
        // recurve make root.left to left list
        convertCore(root.left);
        // connect left list with root node
        root.left = lastNodeOfList;
        if (lastNodeOfList != null) {
            lastNodeOfList.right = root;
        }
        // recurve make root.right to right list
        // now, root is the last node of list
        lastNodeOfList = root;
        convertCore(root.right);
    }
}
