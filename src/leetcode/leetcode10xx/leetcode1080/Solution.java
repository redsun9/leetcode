package leetcode.leetcode10xx.leetcode1080;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int dfs = dfs(root, limit, 0);
        return dfs >= limit ? root : null;
    }

    private static int dfs(TreeNode root, int limit, int curSum) {
        if (root.left == null && root.right == null) return root.val;
        int max = Integer.MIN_VALUE;
        if (root.left != null) {
            int dfs = dfs(root.left, limit, curSum + root.val);
            max = dfs;
            if (dfs + curSum + root.val < limit) root.left = null;
        }
        if (root.right != null) {
            int dfs = dfs(root.right, limit, curSum + root.val);
            max = Math.max(max, dfs);
            if (dfs + curSum + root.val < limit) root.right = null;
        }
        return max + root.val;
    }
}
