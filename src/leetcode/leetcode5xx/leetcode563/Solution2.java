package leetcode.leetcode5xx.leetcode563;

import leetcode.tools.TreeNode;

public class Solution2 {
    public int findTilt(TreeNode root) {
        return sumTilt(root).tilt;
    }

    private static Pair sumTilt(TreeNode root) {
        if (root == null) return new Pair(0, 0);
        Pair left = sumTilt(root.left);
        Pair right = sumTilt(root.right);
        return new Pair(
                root.val + left.sum + right.sum,
                Math.abs(left.sum - right.sum) + left.tilt + right.tilt
        );
    }

    private static class Pair {
        int sum, tilt;

        public Pair(int sum, int tilt) {
            this.sum = sum;
            this.tilt = tilt;
        }
    }
}
