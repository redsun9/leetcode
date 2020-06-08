package leetcode.leetcode3xx.leetcode337;

import leetcode.tools.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        Pair pair = robTree(root);
        return Math.max(pair.a, pair.b);
    }

    private static Pair robTree(TreeNode root) {
        if (root == null) return new Pair(0, 0);
        Pair left = robTree(root.left);
        Pair right = robTree(root.right);
        return new Pair(root.val + left.b + right.b, Math.max(left.a, left.b) + Math.max(right.a, right.b));
    }

    private static class Pair {
        private final int a, b; // a - robbed, b - untouched

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
