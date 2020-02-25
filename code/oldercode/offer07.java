package oldercode;

import java.util.HashMap;

/**
 * [7] 重建二叉树
 * 
 * 题目：根据二叉树的前序遍历和中序遍历的序列，重构二叉树(不含重复元素)
 * 
 * 思路：前序遍历序列，中-左-右
 *      中序遍历序列，左-中-右
 *      通过先序遍历序列知道根节点，将先序和中序遍历序列分为左子树和右子树部分，再递归重复操作
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // use map to record inorder's value and its index
        // then you can quickly search value's index in inorder
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return reConstructBinaryTreeCore(inMap, pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeCore(HashMap<Integer, Integer> inMap, int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // according to the preorder's first value creat the root TreeNode
        int value = pre[preStart];
        TreeNode node = new TreeNode(value);
        // search the root's index in inorder by map 
        // and calculate number of left sequence for division origin sequence
        int indexInInorder = inMap.get(value);
        int offset = indexInInorder - inStart;
        // recurve to reconstructtree by left sequence and right sequence
        node.left = reConstructBinaryTreeCore(inMap, pre, in, preStart + 1, preStart + offset, inStart, indexInInorder - 1);
        node.right = reConstructBinaryTreeCore(inMap, pre, in, preStart + offset + 1, preEnd, indexInInorder + 1, inEnd);
        return node;
    }
}
