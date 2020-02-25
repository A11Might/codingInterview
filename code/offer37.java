/**
 * [37] 序列化二叉树
 * 
 * 题目: 实现两个函数, 分别用来序列化和反序列化二叉树.
 * 
 * 思路: 怎么序列化就怎么反序列化.
 *      https://github.com/A11Might/practicecode/blob/master/learningCode/SerializeAndReconstructTree.java
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    /**
     * 先序遍历序列化与反序列化.
     */
    // when deserializer, the string always used this.
    private String data;

    // Encodes a tree to a single string.
    // serialize to 1_2_3_#_#_4_5_#_#_#_#
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "_" + serialize(root.left) + "_" + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.data = data;
        return deserializeCore();
    }

    private TreeNode deserializeCore() {
        if (data.length() == 0) {
            return null;
        }
        int index = data.indexOf("_");
        String value = index == -1 ? data : data.substring(0, index);
        data = index == -1 ? "" : data.substring(index + 1);
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserializeCore();
        root.right = deserializeCore();

        return root;
    }

    /**
     * 层次遍历实现序列化和反序列化.
     */
    // Encodes a tree to a single string.
    // serialize to 1_2_3_#_#_4_5_#_#_#_#_ in the last have a "_"
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String ret = root.val + "_";
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // queue couldn't add null element,
            // so node transform to string didn't take place poll operation.
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                ret += cur.left.val + "_";
                queue.offer(cur.left);
            } else {
                ret += "#_";
            }
            if (cur.right != null) {
                ret += cur.right.val + "_";
                queue.offer(cur.right);
            } else {
                ret += "#_";
            }
        }

        return ret;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        this.data = data;
        TreeNode root = generateTreeNode();
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            cur.left = generateTreeNode();
            cur.right = generateTreeNode();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return root;
    }

    private TreeNode generateTreeNode() {
        int index = data.indexOf("_");
        String value = data.substring(0, index);
        data = index == data.length() - 1 ? "" : data.substring(index + 1);
        if (value.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(value));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));