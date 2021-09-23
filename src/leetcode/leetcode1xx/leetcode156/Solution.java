package leetcode.leetcode1xx.leetcode156;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return upsideDownBinaryTree(root, null);
    }

    private static TreeNode upsideDownBinaryTree(TreeNode root, TreeNode parent) {
        if (root == null) return parent;
        TreeNode newRoot = upsideDownBinaryTree(root.left, root);
        if (parent != null) {
            root.left = parent.right;
            root.right = parent;
            parent.left = null;
            parent.right = null;
        }
        return newRoot;
    }
}
