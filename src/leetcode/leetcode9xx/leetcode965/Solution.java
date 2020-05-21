package leetcode.leetcode9xx.leetcode965;

import leetcode.tools.TreeNode;

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private static boolean isUnivalTree(TreeNode root, int val) {
        return root.val == val
                && (root.left == null || isUnivalTree(root.left, val))
                && (root.right == null || isUnivalTree(root.right, val));
    }
}
