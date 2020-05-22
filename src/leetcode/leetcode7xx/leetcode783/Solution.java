package leetcode.leetcode7xx.leetcode783;

import leetcode.tools.TreeNode;

public class Solution {
    public int minDiffInBST(TreeNode root) {
        return diff(root).diff;
    }

    public Triple diff(TreeNode root) {
        int min = root.val, max = root.val, diff = Integer.MAX_VALUE;
        if (root.left != null) {
            Triple left = diff(root.left);
            min = left.min;
            diff = min(diff, left.diff, root.val - left.max);
        }
        if (root.right != null) {
            Triple right = diff(root.right);
            max = right.max;
            diff = min(diff, right.diff, right.min - root.val);
        }
        return new Triple(min, max, diff);
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private static class Triple {
        private final int min, max, diff;

        public Triple(int min, int max, int diff) {
            this.min = min;
            this.max = max;
            this.diff = diff;
        }
    }
}
