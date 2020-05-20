package leetcode.leetcode5xx.leetcode563;

import leetcode.tools.TreeNode;

public class Solution {
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int val = Math.abs(sum(root.left) - sum(root.right));
        return val + findTilt(root.left) + findTilt(root.right);
    }

    private static int sum(TreeNode root) {
        if (root == null) return 0;
        else return root.val + sum(root.left) + sum(root.right);
    }
}
