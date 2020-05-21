package leetcode.leetcode11xx.leetcode1123;

import leetcode.tools.TreeNode;

public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lca(root, 0).node;
    }

    private static Pair lca(TreeNode root, int depth) {
        if (root.left == null && root.right == null) return new Pair(root, depth);
        if (root.left == null) return lca(root.right, depth + 1);
        if (root.right == null) return lca(root.left, depth + 1);
        Pair right = lca(root.right, depth + 1);
        Pair left = lca(root.left, depth + 1);
        if (left.depth == right.depth) return new Pair(root, left.depth);
        return left.depth > right.depth ? left : right;
    }

    private static class Pair {
        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        TreeNode node;
        int depth;
    }
}
