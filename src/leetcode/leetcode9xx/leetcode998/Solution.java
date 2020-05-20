package leetcode.leetcode9xx.leetcode998;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return insert(root, val);
    }

    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else {
            if (root.val <= val) {
                TreeNode parent = new TreeNode(val);
                parent.left = root;
                return parent;
            } else {
                root.right = insert(root.right, val);
                return root;
            }
        }
    }
}
