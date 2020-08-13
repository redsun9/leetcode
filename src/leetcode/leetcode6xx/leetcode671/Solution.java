package leetcode.leetcode6xx.leetcode671;

import leetcode.tools.TreeNode;

public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int ans = dfs(root, root.val);
        return ans != root.val ? ans : -1;
    }

    private static int dfs(TreeNode root, int val) {
        if (root == null) return val;
        if (root.val != val) return root.val;
        int left = dfs(root.left, val);
        int right = dfs(root.right, val);
        if (left == val) return right;
        if (right == val) return left;
        return Math.min(left, right);
    }
}
