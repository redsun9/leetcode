package leetcode.leetcode10xx.leetcode1026;

import leetcode.tools.TreeNode;

public class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root).maxDiff;
    }

    private static Triple maxDiff(TreeNode root) {
        int maxVal = root.val, minVal = root.val, maxDiff = 0;
        if (root.left != null) {
            Triple triple = maxDiff(root.left);
            maxVal = Math.max(maxVal, triple.maxVal);
            minVal = Math.min(minVal, triple.minVal);
            maxDiff = Math.max(maxDiff, triple.maxDiff);
            maxDiff = Math.max(maxDiff, Math.abs(root.val - triple.maxVal));
            maxDiff = Math.max(maxDiff, Math.abs(root.val - triple.minVal));
        }
        if (root.right != null) {
            Triple triple = maxDiff(root.right);
            maxVal = Math.max(maxVal, triple.maxVal);
            minVal = Math.min(minVal, triple.minVal);
            maxDiff = Math.max(maxDiff, triple.maxDiff);
            maxDiff = Math.max(maxDiff, Math.abs(root.val - triple.maxVal));
            maxDiff = Math.max(maxDiff, Math.abs(root.val - triple.minVal));
        }
        return new Triple(maxVal, minVal, maxDiff);
    }

    private static class Triple {
        int maxVal, minVal, maxDiff;

        public Triple(int maxVal, int minVal, int maxDiff) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.maxDiff = maxDiff;
        }
    }
}
