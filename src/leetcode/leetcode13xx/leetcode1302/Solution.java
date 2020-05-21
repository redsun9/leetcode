package leetcode.leetcode13xx.leetcode1302;

import leetcode.tools.TreeNode;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        return deepestLeavesSum(root, 0).sum;
    }

    private static Pair deepestLeavesSum(TreeNode root, int depth) {
        if (root.left == null && root.right == null) return new Pair(root.val, depth);
        if (root.left == null) return deepestLeavesSum(root.right, depth + 1);
        if (root.right == null) return deepestLeavesSum(root.left, depth + 1);
        Pair left = deepestLeavesSum(root.left, depth + 1);
        Pair right = deepestLeavesSum(root.right, depth + 1);
        int d = Math.max(left.depth, right.depth);
        int ans = 0;
        if (left.depth == d) ans += left.sum;
        if (right.depth == d) ans += right.sum;
        return new Pair(ans, d);
    }

    private static class Pair {
        int sum;
        int depth;

        public Pair(int sum, int depth) {
            this.sum = sum;
            this.depth = depth;
        }
    }
}
