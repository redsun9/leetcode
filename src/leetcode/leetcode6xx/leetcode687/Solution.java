package leetcode.leetcode6xx.leetcode687;

import leetcode.tools.TreeNode;

public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        return dfs(root).max;
    }

    private static Pair dfs(TreeNode root) {
        if (root.left == null && root.right == null) return new Pair(0, 0);
        int max = 0;
        int rootLen = 0;
        int rootMax = 0;
        if (root.left != null) {
            Pair left = dfs(root.left);
            if (root.left.val == root.val) {
                rootLen += left.rootMax + 1;
                rootMax = Math.max(rootMax, left.rootMax + 1);
            }
            max = Math.max(max, left.max);
        }
        if (root.right != null) {
            Pair right = dfs(root.right);
            if (root.right.val == root.val) {
                rootLen += right.rootMax + 1;
                rootMax = Math.max(rootMax, right.rootMax + 1);
            }
            max = Math.max(max, right.max);
        }
        max = Math.max(max, rootLen);
        return new Pair(max, rootMax);
    }

    private static class Pair {
        int max;
        int rootMax;

        public Pair(int max, int rootMax) {
            this.max = max;
            this.rootMax = rootMax;
        }
    }
}
