package leetcode.leetcode4xx.leetcode404;

import leetcode.tools.TreeNode;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private static int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return isLeft ? root.val : 0;
        else return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
