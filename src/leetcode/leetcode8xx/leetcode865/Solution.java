package leetcode.leetcode8xx.leetcode865;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root, 0).node;
    }

    private static Pair dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) return new Pair(root, depth);
        if (root.left == null) return dfs(root.right, depth + 1);
        if (root.right == null) return dfs(root.left, depth + 1);
        Pair left = dfs(root.left, depth + 1);
        Pair right = dfs(root.right, depth + 1);
        if (left.depth == right.depth) return new Pair(root, left.depth);
        return left.depth > right.depth ? left : right;
    }

    private static class Pair {
        private TreeNode node;
        private int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
