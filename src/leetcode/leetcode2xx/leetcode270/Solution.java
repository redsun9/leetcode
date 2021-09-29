package leetcode.leetcode2xx.leetcode270;

import leetcode.tools.TreeNode;

public class Solution {
    public int closestValue(TreeNode root, double target) {
        Pair pair = dfs(root, target);
        if (pair.ceil == null) return pair.floor;
        if (pair.floor == null) return pair.ceil;
        if (target - pair.floor <= pair.ceil - target) return pair.floor;
        else return pair.ceil;
    }

    private static Pair dfs(TreeNode root, double target) {
        if (root == null) return new Pair(null, null);
        if (root.val == target) return new Pair(root.val, root.val);
        if (root.val < target) {
            Pair right = dfs(root.right, target);
            if (right.floor == null || root.val > right.floor) right.floor = root.val;
            return right;
        } else {
            Pair left = dfs(root.left, target);
            if (left.ceil == null || root.val < left.ceil) left.ceil = root.val;
            return left;
        }
    }

    private static class Pair {
        Integer ceil, floor;

        public Pair(Integer ceil, Integer floor) {
            this.ceil = ceil;
            this.floor = floor;
        }
    }
}
