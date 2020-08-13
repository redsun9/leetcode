package leetcode.leetcode1xx.leetcode110;

import leetcode.tools.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    }
}
