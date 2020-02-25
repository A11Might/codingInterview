import java.util.HashMap;

/**
 * [07] 重建二叉树
 *
 * 题目: 根据二叉树的前序遍历和中序遍历的序列, 重构二叉树(不含重复元素).
 *
 * 思路: 前序遍历序列为, 中-左-右,
 *      中序遍历序列为, 左-中-右.
 *      前序遍历序列的第一个节点值为根节点的值, 通过这个根结点的值将前序和中序遍历序列都分为左子树和右子树部分, 然后分别对左右子树递归地求解.
 *      (注意: 是通过左右子树的节点数来划分前序和中序遍历序列, 而不是异想)
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
    private HashMap<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // use map to record inorder's value and it's index,
        // then you can quickly search value's index in inorder.
        inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTreeCore(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd) {
        // base case.
        if (preStart > preEnd) {
            return null;
        }
        // according to the preorder's first value creat the root TreeNode.
        int value = preorder[preStart];
        TreeNode root = new TreeNode(value);
        // search the root's index in inorder by inMap,
        // and use this index to calculate the number of left subtree sequence,
        // for division origin sequence to left subtree part and right subtree part.
        int indexInInorder = inMap.get(value);
        int leftSubTreeSize = indexInInorder - inStart;
        // recursive call buildTreeCore to construct current node's left subtree and right subtree.
        root.left = buildTreeCore(preorder, preStart + 1, preStart + leftSubTreeSize,
                inorder, inStart, indexInInorder - 1);
        root.right = buildTreeCore(preorder, preStart + leftSubTreeSize + 1, preEnd,
                inorder, indexInInorder + 1, inEnd);

        return root;
    }
}