package leetcode.leetcode2xx.leetcode298;

import leetcode.tools.TreeNode;

public class Solution {
    public int longestConsecutive(TreeNode root) {
        return dfs(root, 0, 0);
    }

    private static int dfs(TreeNode root, int currentLen, int previous) {
        if (root == null) return currentLen;
        if (root.val == previous + 1) return Math.max(
                dfs(root.left, currentLen + 1, root.val),
                dfs(root.right, currentLen + 1, root.val));
        else return Math.max(
                currentLen,
                Math.max(
                        dfs(root.left, 1, root.val),
                        dfs(root.right, 1, root.val)
                )
        );
    }
}
