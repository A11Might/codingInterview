/**
 * [33] 二叉搜索树的后序遍历序列
 * 
 * 题目: 判断给定数组是不是某二叉搜索树的后序遍历结果. 假设输入的数组的任意两个数字都互不相同.
 * 
 * 思路: 后序遍历序列中的数字可以分为三部分: 第一部分是左子树节点的值, 它们都比根节点的值小; 第二部分是右子树节点的值, 它们都比根节点的值大;
 *      第三部分就是最后一个数字即树的根节点的值.
 *      根据根节点的大小, 将序列分为左子树和右子树部分后, 再判断根节点和左右子树的序列是否符合二叉搜索树的特性(即左子树序列中元素都小于根节
 *      点, 右子树序列中元素都大于根节点), 最后递归判断左右子树的序列是否是二叉搜索树.
 */
class Solution {
    /**
     * 时间复杂度: O(n ^ 2)
     * 空间复杂度: O(n)
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return verifyPostorderCore(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorderCore(int[] postorder, int start, int end) {
        // when subtree have two, one or none node, the subtree is binary search tree.
        // when subtree have two nodes, means the node in the end is root node,
        // and the other node is left or right subtree, this node can bigger and also can smaller than root,
        // so the tree must be a binary search tree when it only have two node.
        if (end - start <= 1) {
            return true;
        }
        // last element of sequence is root.
        // though root value split sequence to left subtree sequence and right subtree sequence,
        // and judge the root and those two subtree sequence conform to binary search tree or not.
        int rootValue = postorder[end];
        int index = start;
        while (index < end && postorder[index] < rootValue) {
            index++;
        }
        for (int i = index; i < end; i++) {
            if (postorder[i] < rootValue) {
                return false;
            }
        }

        // recursive call verifyPostorderCore to judge those two subtree sequence is binary search tree or not.
        return verifyPostorderCore(postorder, start, index - 1)
                && verifyPostorderCore(postorder, index, end - 1);
    }
}