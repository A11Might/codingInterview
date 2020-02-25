/**
 * [26] 树的子结构
 * 
 * 题目: 判断给定二叉树 B 是不是 A 的子结构. (约定空树不是任意一个树的子结构)
 *      (B 是 A 的子结构，, 即 A 中有出现和 B 相同的结构和节点值)
 *
 * 思路: node1              node2
 *        1                   1
 *      3   5               3   5
 *     2 4 6 7
 *      遍历 A 树, 将以每个节点为根节点的子树和 B 树比较, 判断 B 是否为其子树.
 *      若 node2 遍历完, 则 node2 是 node1 的子树, node1 遍历完 node2 还没遍历完, 则不是.
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
     * 时间复杂度: O(m * n) (m 为 A 的节点数, n 为 B 的节点数)
     * 空间复杂度: O(n)
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStructureCore(A, B)
                || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSubStructureCore(TreeNode root1, TreeNode root2) {
        // root1 == null && root2 == null,
        // or root1 != null && root2 == null.
        if (root2 == null) {
            return true;
        }
        // root1 == null & root2 != null,
        // or root1 noe equal root2.
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return isSubStructureCore(root1.left, root2.left) && isSubStructureCore(root1.right, root2.right);
    }
}