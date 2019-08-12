package offer;

/**
 * [33] 二叉搜索树的后序遍历序列
 * 
 * 题目：判断给定数组是不是某二叉搜索树的后序遍历(数组中的值都不相等)
 * 
 * 思路：后序遍历序列，左-右-中
 *      后序遍历序列最后一位为根节点，再通过二叉搜素树的特点
 *      左子树的节点值都小于根节点，右子树的节点值都大于根节点
 *      将序列分为左子树和右子树部分，再递归重复操作
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBSTCore(int[] sequence, int start, int end) {
        // subtree have one or none node
        // those subtree is binary search tree
        if (start >= end) {
            return true;
        }
        // last element of sequence is root
        // though root value split sequence to left subtree sequence and right one
        // and judge those two subtree sequence valid or not 
        int rootValue = sequence[end];
        int i = 0;
        for (; i < end - 1; i++) {
            if (sequence[i] > rootValue) {
                break;
            }
        }
        for (int j = i ; j < end - 1; j++) {
            if (sequence[j] < rootValue) {
                return false;
            }
        }
        // recurve to judge those two subtree sequence
        // is binary search tree or not
        return VerifySquenceOfBSTCore(sequence, start, i - 1) && VerifySquenceOfBSTCore(sequence, i + 1, end - 1);
    }
}
