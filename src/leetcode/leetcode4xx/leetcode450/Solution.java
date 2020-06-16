package leetcode.leetcode4xx.leetcode450;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode ans = ceiling(root);
            ans.left = root.left;
            ans.right = root.right;
            return ans;
        } else {
            if (root.val > key) root.left = deleteNode(root.left, key);
            else root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private static TreeNode ceiling(TreeNode root) {
        if (root.left.right == null) {
            TreeNode ans = root.left;
            root.left = root.left.left;
            ans.left = null;
            return ans;
        } else {
            root = root.left;
            while (root.right.right != null) root = root.right;
            TreeNode ans = root.right;
            root.right = root.right.left;
            ans.left = null;
            return ans;
        }
    }
}
